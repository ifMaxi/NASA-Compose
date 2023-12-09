# NASA Compose

An app that shows the Astronomical Image of the Day and its description by a NASA expert. Use the APOD api of the page [NASA Open APIs](https://api.nasa.gov/).

### Components and libraries

- Kotlin
- Jetpack compose
- Material 3
- Navigation compose
- Dependency Injection (Dagger/Hilt)
- Retrofit
- Kotlin Serialization
- Coil (With Gif and VideoFrame decoders.)
- Lottie (For an animated image on startup.)
- Downloaded Font

### Architecture

The type of architecture used for this project was MVVM(Model-View-ViewModel). This being the architecture recommended by Google to create and work on Android applications.

This is divided into the: 

- Model: Which represents the data and business logic
- View: Which represents the UI
- ViewModel: Which represents the bridge between the View and the Model

## Note

Please. In order to access the content of the app, in this case the image and its description, you will need your own API KEY that you can obtain from the same page provided above.

Once you have your API KEY you will need to place it in a "local.properties" file and configure it in your Build.Gradle.

### Screenshots

`TODO: Screenshots`
