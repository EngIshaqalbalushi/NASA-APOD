# NASA APOD Explorer

A full-featured Astronomy Picture of the Day explorer with a Java Spring Boot backend, a dark futuristic UI, and an AI-powered chatbot.

## Pages

- **Home** -- APOD of the day with full-bleed hero, tags, full-res and yesterday buttons
- **Gallery** -- Masonry grid of random APODs with search, date filter, infinite scroll
- **About** -- Project history, team, educational impact
- **Community** -- Share today's APOD, trending topics, newsletter signup
- **API Docs** -- Developer portal documenting the NASA APOD API

## How to Run

### Option 1: Java Backend (full featured)

**Requirements:** Java 21+, Maven 3.8+

```bash
mvn spring-boot:run
```

Open http://localhost:8080

**Endpoints served by the backend:**
| Route | Description |
|-------|-------------|
| `/` | Home page |
| `/gallery` | Gallery page |
| `/about` | About page |
| `/community` | Community page |
| `/api-docs` | API documentation |
| `/api/apod/today` | Today's APOD (JSON) |
| `/api/apod?date=YYYY-MM-DD` | APOD by date (JSON) |
| `/api/apod/range?start_date=&end_date=` | Date range (JSON) |
| `/api/apod/random?count=N` | Random APODs (JSON) |
| `POST /api/newsletter` | Newsletter signup (JSON) |
| `POST /api/chat` | AI chat via DeepSeek (JSON -- `{message: "..."}`) |

To set a custom API key for the NASA APOD API:
```bash
NASA_API_KEY=your_key_here mvn spring-boot:run
```

### AI Chatbot (DeepSeek via OpenRouter)

The chatbot on every page is powered by **DeepSeek** through OpenRouter.

1. Get an API key from [openrouter.ai/keys](https://openrouter.ai/keys)
2. Set it as an environment variable:
```bash
OPENROUTER_API_KEY=sk-or-v1-xxxx mvn spring-boot:run
```
Or edit `src/main/resources/application.properties`:
```properties
openrouter.api.key=sk-or-v1-xxxx
openrouter.model=deepseek/deepseek-chat
```

### Option 2: Docker

**Requirements:** Docker, Docker Compose

```bash
docker compose up --build
```

Open http://localhost:8080

To use custom API keys:
```bash
NASA_API_KEY=your_key_here OPENROUTER_API_KEY=sk-or-v1-xxxx docker compose up --build
```

### Option 3: Static Site (GitHub Pages)

Open `index.html` directly in a browser or host on any static server. No backend needed -- the page calls the NASA API directly from the browser.

> The API key is exposed client-side with this option. For production, use the Java backend or a serverless proxy.

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.4.4, Maven
- **Frontend:** HTML, Tailwind CSS (CDN), Google Fonts, Material Symbols
- **API:** NASA APOD API (api.nasa.gov)
- **AI:** DeepSeek via OpenRouter (chatbot)

## Project Structure

```
src/main/java/com/nasa/apod/
  ApodApplication.java           # Entry point
  controller/
    ApodController.java          # REST API
    ChatController.java          # DeepSeek chat endpoint
    PageController.java          # Serves HTML pages
    NewsletterController.java
  service/
    NasaApodService.java         # NASA API calls + cache
    ChatService.java             # OpenRouter DeepSeek calls
  model/
    ApodResponse.java
    NewsletterSubscription.java
src/main/resources/
  application.properties         # API key config
nasa_apod_home/code.html         # Home page
nasa_apod_gallery_redesign/      # Gallery page
nasa_apod_about/                 # About page
nasa_apod_community/             # Community page
nasa_apod_api_developers/        # API docs page
index.html                       # Standalone static file
Dockerfile                       # Docker build
docker-compose.yml               # Docker compose config
.dockerignore
pom.xml
README.md
```
