# ✦ Fable - Storytelling App

Fable is a interactive storytelling Android application built entirely with Kotlin and Jetpack Compose.

## 📱 Features & Evaluation Points Addressed

* **Immersive UI/UX:** Built a clean, editorial layout using Jetpack Compose with custom typography and negative space for readability. 
* **Dynamic Theming:** Supports dynamic Light and Dark modes based on system preferences, along with a custom manual override toggle in the header.
* **Performance Optimization:** Utilized `LazyColumn` for efficient list rendering and structured the UI to prevent unnecessary recompositions.
* **Premium Animations (Bonus):** Integrated `Navigation Compose` to provide smooth `fadeIn` and `slideInHorizontally` transitions between the Home and Detail screens.
* **Advanced Filtering (Bonus):** Built a custom Compose `LazyRow` filter system allowing users to sort stories by category (Mystery, Drama, etc.) alongside a "Favorites" toggle.

## 🛠️ Tech Stack & Architecture

* **UI:** Jetpack Compose (Material 3)
* **Language:** Kotlin
* **State Management:** `StateFlow` and `ViewModel`
* **Navigation:** Jetpack Navigation Compose

## 📂 Project Structure

```text
Fable/
├── app/src/main/java/com/abhinav/fable/
│   ├── data/
│   │   ├── MockData.kt               # Local mock data for stories
│   │   └── StoryRepository.kt        # Simulates API network calls
│   ├── model/
│   │   └── Story.kt                  # Domain data class for stories
│   ├── ui/
│   │   ├── components/
│   │   │   ├── HomeTopBar.kt         # Custom header with theme & favorite toggles
│   │   │   └── StoryCard.kt          # Reusable card for the story feed
│   │   ├── navigation/
│   │   │   └── NavGraph.kt           # Routing and transition animations
│   │   ├── screens/
│   │   │   ├── HomeScreen.kt         # Main feed with category filters
│   │   │   └── StoryDetailScreen.kt  # Detail reading view with parallax header
│   │   └── theme/
│   │       ├── Color.kt              # Light/Dark mode palettes & gradients
│   │       ├── Theme.kt              # App-wide Material 3 theme configuration
│   │       └── Type.kt               # Custom editorial typography
│   ├── viewmodel/
│   │   ├── StoryViewModel.kt         # Manages UI state, favorites, and fetching
│   │   └── UiState.kt                # Sealed class for Loading/Success/Error states
│   └── MainActivity.kt               # App entry point & Theme hoisting
└── README.md                         # Project documentation


## 🚀 Running the App
1. Clone the repository and open it in Android Studio.
2. Sync the Gradle files (Ensure you are using `compileSdk 37` or appropriate).
3. Run the `:app` configuration on an emulator or physical device.
