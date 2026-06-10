# Daily Affirmations App

## Overview

Daily Affirmations App is an Android application built using Kotlin, Jetpack Compose, MVVM Architecture, and Firebase Firestore. The app allows users to create, update, view, and delete personal affirmations while storing data in the cloud through Firebase Firestore.

## Features

* Add new affirmations
* Update existing affirmations
* Delete affirmations
* Real-time data synchronization using Firebase Firestore
* Modern UI built with Jetpack Compose
* MVVM Architecture for clean code organization

## ScreenShots 

![image alt](https://github.com/Aman298871/affirmation_app/blob/a1b9a65274c475b0ec6b22f9d203de3410268810/photo_2026-06-10_20-22-28.jpg)
![image alt](https://github.com/Aman298871/affirmation_app/blob/a1b9a65274c475b0ec6b22f9d203de3410268810/photo_2026-06-10_20-22-30.jpg)
![image alt](https://github.com/Aman298871/affirmation_app/blob/a1b9a65274c475b0ec6b22f9d203de3410268810/photo_2026-06-10_20-22-32.jpg)
![image alt](https://github.com/Aman298871/affirmation_app/blob/a1b9a65274c475b0ec6b22f9d203de3410268810/photo_2026-06-10_20-22-34.jpg)
![image alt](https://github.com/Aman298871/affirmation_app/blob/e90963d9d75c8636c11ee5141aa72bd494bfadbd/photo_2026-06-10_20-22-35.jpg)
![image alt](https://github.com/Aman298871/affirmation_app/blob/e90963d9d75c8636c11ee5141aa72bd494bfadbd/Screenshot%202026-06-10%20201447.png)
## Technologies Used

* Kotlin
* Jetpack Compose
* MVVM Architecture
* Firebase Firestore
* Material 3 Design Components

## Project Structure

### FirestoreRepository

Responsible for all Firebase Firestore operations including:

* Adding affirmations
* Fetching affirmations
* Updating affirmations
* Deleting affirmations

### AffirmationViewModel

Acts as a bridge between the UI and repository layer.

Responsibilities:

* Manage UI state
* Receive data from FirestoreRepository
* Expose data to the Compose UI

### DisplayAffirmationScreen

Main user interface screen that provides:

* Affirmation input field
* Save button
* List of saved affirmations
* Edit affirmation dialog
* Delete functionality

## Architecture

MVVM (Model-View-ViewModel)

UI Layer (Jetpack Compose)
↓
ViewModel Layer
↓
Repository Layer
↓
Firebase Firestore

## Firebase Collection Structure

Collection Name:

affirmations

Document Example:

{
"text": "I am confident and capable."
}

## Future Improvements

* User Authentication
* Categories for affirmations
* Reminder notifications
* Dark Mode support
* Search functionality
* Offline caching
* Favorite affirmations

## Author

Developed using Kotlin, Jetpack Compose, MVVM Architecture, and Firebase Firestore.
