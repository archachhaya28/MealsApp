# 🍽️ Modern Android App with Jetpack Compose

A **modern Android application** built using **Jetpack Compose** with integrations of popular Android architecture components. This app follows **clean architecture** principles using **MVVM**, and leverages **state hoisting** and **coroutines in ViewModel** for better separation of concerns and lifecycle awareness.

---

## ✨ Key Features

- **Jetpack Compose**: Build modern declarative UIs.
- **MVVM Architecture**: Scalable and testable code structure.
- **State Hoisting**: Unidirectional data flow from ViewModel to Composables.
- **Coroutines in ViewModel**: Clean and efficient async operations.
- **LiveData**: Lifecycle-aware observable data holder.
- **Retrofit**: Simplified API communication.
- **Navigation Component**: Type-safe and clean screen transitions.
- **Custom Meals Screen**: A specialized UI for exploring and managing meal content.

---

## 🧱 Architecture Overview

This app uses a modular and layered architecture:

## 🛠 Tech Stack

| Layer          | Technology         |
|----------------|--------------------|
| UI             | Jetpack Compose    |
| Architecture   | MVVM               |
| State Handling | ViewModel, LiveData, State Hoisting |
| Async          | Kotlin Coroutines  |
| Networking     | Retrofit           |
| Navigation     | Jetpack Navigation Compose |

---

## 📱 Customised Meals Screen

A tailored screen that demonstrates:
- Dynamic list of meals from API
- Optimized rendering with `LazyColumn`
- Proper state management with `ViewModel`
- UI state hoisted for reusability and testing
- Error and loading state handling

---

## 🚀 Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/modern-android-meals-app.git
