# World Times (Android)
- This project was completed according to the following task ->>
- [Link Text](https://docs.google.com/document/d/1hMXedydk7HtsJLSARsBFuBel-wjXHoryTO3jQHO_qQk/edit#heading=h.n1cqa1ya84ux)

## Getting Started
- Download the latest Android Studio.
- Clone this repository.
- In Android Studio, create an Android Virtual Device (AVD) that the emulator can use to install and run your app.
- In the toolbar, select your app from the run/debug configurations drop-down menu.
- From the target device drop-down menu, select the AVD that you want to run your app on.
- Click Run.

## Main stack

### Libraries
- **Dagger Hilt** - Dagger Hilt is a dependency injection library for Android, built on top of Dagger. It simplifies the process of dependency injection in Android applications, making it easier to manage and provide dependencies to different parts of your app.
- **Coroutines** - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines were added to Kotlin in version 1.3 and are based on established concepts from other languages.
- **Retrofit** - Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice.
- **GSON** - Gson is a Java library that can be used to convert classes into their JSON representation. It can also be used to convert a JSON string to an equivalent Kotlin object.
- **Navigation Compose** - Navigation Compose is a navigation library for Jetpack Compose, the modern declarative UI toolkit for Android. It provides a robust and intuitive way to handle navigation within your Compose-based Android applications.
- **Jetpack Compose** - Jetpack Compose is the modern declarative UI toolkit for building native Android apps. It offers a simplified and intuitive way to create beautiful and interactive user interfaces using Kotlin.

### Architecture
- **MVI** - Model-View-Intent (MVI) is an architectural pattern that aims to provide a clear separation of concerns and a predictable flow of data in Android applications. It follows a unidirectional data flow approach and promotes immutability and reactive programming principles.
- **Clean Architecture** - Clean Architecture combines a group of practices that produce systems with the following characteristics: Testable; UI-independent (the UI can easily be changed without changing the system); Independent of databases, frameworks, external agencies, and libraries.
