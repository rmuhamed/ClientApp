# ClientApp

[![Build Status](https://travis-ci.org/rmuhamed/PokeTest.svg?branch=master)](https://travis-ci.org/rmuhamed/ClientApp)

[![Code Coverage](https://codecov.io/gh/rmuhamed/ClientApp/branch/master/graph/badge.svg)](https://codecov.io/gh/rmuhamed/ClientApp)

## Pre-requisites
- You must have the **ProvideApp** up and running in order to interact with DB

## Dependencies
- Add jitpack.io repository to your root's build.gradle 
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
- Add the library dependency into your app's build.gradle
```
android { ... }
dependencies {
    ...
    implementation "com.github.rmuhamed:ProviderLibrary:$lib_version"
```


## Usage
- Launch this app and check the available operations

## Technologies involved
- Android SDK
- Kotlin programming language
- Android-library integration (locally)
- Content-Provider interaction

## Coming soon
- More samples in this tiny app