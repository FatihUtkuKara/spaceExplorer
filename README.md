# SpaceExplorer

SpaceExplorer is a modern Android application for exploring SpaceX launches and rocket details. The app is built with a modular, scalable architecture and leverages the latest Android technologies for a robust, maintainable, and user-friendly experience.

---

## Features

- **Browse SpaceX Launches:** View a list of all SpaceX launches with mission details.
- **Rocket Details:** See the rocket name for each launch, fetched dynamically.
- **Offline Support:** Previously loaded data is available offline via local caching.
- **Search & Filter:** Search launches by mission name and filter by status (all, successful, failed, pending).
- **Error & Loading States:** User-friendly error messages, retry actions, and loading indicators.
- **Material Design:** Modern, responsive UI with Material Components.

---

## Tech Stack

- **Kotlin** — Main programming language
- **MVVM Architecture** — Separation of concerns and testability
- **Room** — Local database for offline support
- **Retrofit** — Networking and API calls
- **Hilt** — Dependency injection
- **Coroutines & Flow** — Asynchronous and reactive programming
- **Material Components** — Modern UI/UX
- **Navigation Component** — In-app navigation

---

## Project Structure

```
spaceExplorer/
├── app/         # Application manifest, themes, and entry point
├── data/        # Data layer: models, Room, Retrofit, repository, use cases
├── ui/          # UI layer: Fragments, ViewModels, Adapters, UI resources
```

- **data/model/**: Data classes for launches, rockets, and links
- **data/local/**: Room database, DAOs, type converters
- **data/api/**: Retrofit API interfaces
- **data/repository/**: Repository pattern for data management
- **data/usecase/**: Use cases for business logic
- **ui/launches/**: Main screen, ViewModel, Adapter, and UI state management

---

## Architecture & Data Flow

### Clean MVVM Approach

- **View (Fragment/Activity):** Observes UI state, handles user input, and displays data.
- **ViewModel:** Holds UI state, handles business logic, and interacts with use cases.
- **UseCase:** Encapsulates a single business action (e.g., fetch launches, refresh launches).
- **Repository:** Abstracts data sources (local DB, remote API) and provides a unified interface.
- **Room (DAO):** Local database for caching and offline support.
- **Retrofit (API):** Handles network requests to SpaceX API.

### Data Flow Example

1. **User opens app** → `LaunchesViewModel` triggers `refreshLaunches()`
2. **ViewModel** calls `RefreshLaunchesUseCase`
3. **UseCase** fetches data from SpaceX API via `SpaceXRepository`
4. **Repository** saves data to Room DB
5. **ViewModel** observes Room DB via `GetLaunchesUseCase` and exposes data as `StateFlow`
6. **Fragment** observes `uiState` and updates UI accordingly

---

## Dependency Injection

- **Hilt** is used for dependency injection.
- All repositories, use cases, and ViewModels are provided via Hilt modules.
- Example:
  ```kotlin
  @HiltViewModel
  class LaunchesViewModel @Inject constructor(
      private val getLaunchesUseCase: GetLaunchesUseCase,
      private val refreshLaunchesUseCase: RefreshLaunchesUseCase,
      private val repository: SpaceXRepository
  ) : ViewModel() { ... }
  ```

---

## Offline & Online Scenarios

- **First Launch (Online):** Data is fetched from the API and cached in Room.
- **Subsequent Launches (Offline):** Data is loaded from Room cache.
- **No Data & No Internet:** User sees an error message with retry option.
- **Data Refresh:** Pull-to-refresh or app restart triggers API fetch and updates cache.

---

## Error & Loading State Management

- **Sealed class `LaunchesUiState`** is used for robust UI state management:
  - `Loading`: Shows progress indicator
  - `Success`: Shows data
  - `Error`: Shows error message, icon, and retry button
- **Error Types:** Network, API, unknown errors are handled with specific messages and icons.
- **Retry Mechanism:** User can retry failed actions via UI.

---

## Key Classes

- **SpaceLaunch, Rocket, Links:** Data models for launches and rockets.
- **SpaceXRepository:** Central data manager, abstracts local/remote sources.
- **LaunchesViewModel:** Handles UI state, filtering, and data refresh.
- **LaunchesAdapter:** RecyclerView adapter for displaying launches.
- **Room DAOs:** `LaunchDao`, `RocketDao` for local data access.
- **UseCases:** `GetLaunchesUseCase`, `RefreshLaunchesUseCase` for business logic.

---

## Testing

- **ViewModels** are designed for easy unit testing (business logic is separated).
- **Repositories** can be mocked for integration tests.
- **Room** and **Retrofit** can be tested with in-memory DB and mock web server.

---

## Getting Started

### Prerequisites

- Android Studio Giraffe or newer
- Android SDK 33+
- Internet connection (for first data load)

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/spaceexplorer.git
   cd spaceexplorer
   ```

2. **Open in Android Studio**  
   - File > Open > Select the `spaceExplorer` directory

3. **Build the project**  
   - Let Gradle sync and build dependencies

4. **Run the app**  
   - Choose an emulator or device and click "Run"

---

## Usage

- On first launch (with internet), the app fetches SpaceX launches and caches them locally.
- You can search and filter launches.
- Tap a launch to see more details (if implemented).
- If offline, previously loaded data is shown.
- Error and loading states are handled gracefully.

---

## Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements and bug fixes.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request

---

## License

This project is licensed under the MIT License.

---

## Acknowledgements

- [SpaceX API](https://github.com/r-spacex/SpaceX-API)
- [Material Components for Android](https://material.io/develop/android)
- [Android Developers Documentation](https://developer.android.com/docs)

---

*Happy exploring! 🚀* 