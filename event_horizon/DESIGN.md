---
name: Event Horizon
colors:
  surface: '#131313'
  surface-dim: '#131313'
  surface-bright: '#3a3939'
  surface-container-lowest: '#0e0e0e'
  surface-container-low: '#1c1b1b'
  surface-container: '#201f1f'
  surface-container-high: '#2a2a2a'
  surface-container-highest: '#353534'
  on-surface: '#e5e2e1'
  on-surface-variant: '#b9cacb'
  inverse-surface: '#e5e2e1'
  inverse-on-surface: '#313030'
  outline: '#849495'
  outline-variant: '#3b494b'
  surface-tint: '#00dbe9'
  primary: '#dbfcff'
  on-primary: '#00363a'
  primary-container: '#00f0ff'
  on-primary-container: '#006970'
  inverse-primary: '#006970'
  secondary: '#e1b6ff'
  on-secondary: '#4c007c'
  secondary-container: '#a20fff'
  on-secondary-container: '#faebff'
  tertiary: '#f6f4ff'
  on-tertiary: '#2e303b'
  tertiary-container: '#d8d8e7'
  on-tertiary-container: '#5c5e6a'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#7df4ff'
  primary-fixed-dim: '#00dbe9'
  on-primary-fixed: '#002022'
  on-primary-fixed-variant: '#004f54'
  secondary-fixed: '#f2daff'
  secondary-fixed-dim: '#e1b6ff'
  on-secondary-fixed: '#2e004e'
  on-secondary-fixed-variant: '#6c00ae'
  tertiary-fixed: '#e1e1f0'
  tertiary-fixed-dim: '#c5c5d4'
  on-tertiary-fixed: '#191b26'
  on-tertiary-fixed-variant: '#444652'
  background: '#131313'
  on-background: '#e5e2e1'
  surface-variant: '#353534'
typography:
  display-lg:
    fontFamily: Space Grotesk
    fontSize: 72px
    fontWeight: '700'
    lineHeight: 80px
    letterSpacing: -0.02em
  display-lg-mobile:
    fontFamily: Space Grotesk
    fontSize: 40px
    fontWeight: '700'
    lineHeight: 48px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Space Grotesk
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
  headline-lg-mobile:
    fontFamily: Space Grotesk
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 28px
  label-caps:
    fontFamily: JetBrains Mono
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.1em
  data-point:
    fontFamily: JetBrains Mono
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
rounded:
  sm: 0.125rem
  DEFAULT: 0.25rem
  md: 0.375rem
  lg: 0.5rem
  xl: 0.75rem
  full: 9999px
spacing:
  unit: 8px
  container-max: 1440px
  gutter: 24px
  margin-desktop: 64px
  margin-mobile: 20px
---

## Brand & Style
The design system is engineered to evoke the vast, silent majesty of deep space. It targets science enthusiasts, educators, and stargazers who seek an immersive, cinematic experience when exploring cosmic imagery. 

The aesthetic is a fusion of **Glassmorphism** and **Minimalism**. UI elements are treated as futuristic heads-up display (HUD) overlays—highly functional yet ethereal—floating over high-resolution celestial photography. The emotional response is one of awe, precision, and discovery. By prioritizing "blackspace" over white space, the system allows the Astronomy Picture of the Day to serve as the singular light source of the interface, mimicking the experience of looking through a telescope lens.

## Colors
The palette is rooted in the "Obsidian" neutral (#050505) to ensure perfect black levels on OLED displays, creating a seamless transition between the UI and the void of space. 

- **Primary (Star-field Cyan):** Used for critical actions, active states, and technical data points.
- **Secondary (Nebula Purple):** Reserved for highlights, discovery features, and soft radial gradients that mimic distant cosmic clouds.
- **Surface (Deep Cosmic Blue):** Used for card backgrounds and navigation bars with low opacity to maintain the glass effect.
- **Text:** Stark white for maximum legibility against the dark void, with muted slate grays for metadata to establish hierarchy.

## Typography
The typography system balances technical precision with modern readability. 

- **Headlines:** Space Grotesk provides a geometric, "space-age" feel that remains legible at large scales. Use it for titles and major section headers.
- **Body:** Inter is the workhorse for long-form descriptions of astronomical phenomena, chosen for its clarity and neutral tone.
- **Labels & Data:** JetBrains Mono is utilized for technical metadata (e.g., coordinates, light-years, camera specs). Its monospaced nature reinforces the scientific, HUD-inspired aesthetic.

## Layout & Spacing
The layout follows a **Fluid Grid** model with generous margins to prevent the UI from feeling cramped. 

- **Desktop:** A 12-column grid with wide 64px margins. Content is often center-aligned to create a focused, cinematic viewing experience.
- **Mobile:** A 4-column grid with 20px margins. Elements stack vertically, prioritizing the image aspect ratio.
- **Rhythm:** Use increments of 8px for internal padding. To emphasize the "infinite" feel of space, use oversized padding (80px+) between major vertical sections.

## Elevation & Depth
Depth is created through **Glassmorphism** rather than traditional shadows. 

- **Surfaces:** Use a background blur (12px to 20px) combined with a semi-transparent fill of the Deep Cosmic Blue (#0B0D17) at 40-60% opacity.
- **Outlines:** Instead of shadows, use 1px "Inner Glow" borders. These should be top-left weighted with a white or cyan stroke at 10-20% opacity to simulate light hitting the edge of a glass panel.
- **Layering:** Background photography stays at the lowest z-index. UI panels float above, with higher-level modals receiving a slightly brighter background tint and increased blur.

## Shapes
The design system utilizes **Soft** roundedness (4px to 12px) to maintain a precise, engineered appearance while avoiding the aggression of sharp corners. 

- **Small Components:** Checkboxes and small tags use a 4px radius.
- **Main Panels:** Content cards and glass overlays use a 12px radius.
- **Interactive Elements:** Buttons maintain a consistent 8px radius, creating a "module" look common in aerospace interfaces.

## Components
- **Buttons:** Primary buttons use a solid Star-field Cyan fill with black text for high contrast. Secondary buttons are "Ghost" style with a 1px cyan border and backdrop blur.
- **Input Fields:** Semi-transparent dark backgrounds with a bottom-only border that glows Cyan on focus. Labels should use the Monospaced font in all-caps.
- **Cards:** Borderless glass panels with 20px backdrop blur. Content should have ample internal padding (32px) to feel premium.
- **Chips/Tags:** Small, pill-shaped outlines using Nebula Purple for categories like "Nebula," "Galaxy," or "Exoplanet."
- **HUD Overlays:** Use thin vertical and horizontal lines (0.5px) and "crosshair" corner decorations to frame specific images, reinforcing the observatory feel.
- **Progress Bars:** Use a thin, neon-glow line for image loading states or scroll progress, utilizing the Cyan-to-Purple gradient.