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

<img src="https://github.com/ifMaxi/NASACompose/assets/112733459/ec2d8ea6-c9e2-4f89-9493-ad2ecf10ccd2" width="400" height="800">
<img src="https://github.com/ifMaxi/NASACompose/assets/112733459/156edbf2-1837-42ef-98f3-0a04fadcfa86" width="400" height="800">
<img src="https://github.com/ifMaxi/NASACompose/assets/112733459/c10bfbdf-6195-45ea-8729-bf1333407e2c" width="400" height="800">
