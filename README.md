🍽️ Delishio — Your Personal Recipe Companion
<p align="center"> <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/> <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/> <img src="https://img.shields.io/badge/Android%20Studio-4285F4?style=for-the-badge&logo=androidstudio&logoColor=white"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"/> <img src="https://img.shields.io/badge/Retrofit-563D7C?style=for-the-badge&logo=android&logoColor=white"/> <img src="https://img.shields.io/badge/Room%20Database-5C2D91?style=for-the-badge&logo=android&logoColor=white"/> </p>
📚 Table of Contents

Screenshots

Description

Features

Tech Stack

API Used

Folder Structure

Installation

Contributing

License

📸 Screenshots
<p align="center"> <img src="https://github.com/jaatitkhaoula42/delishio/blob/main/delishio1.png?raw=true" width="260"/> <img src="https://github.com/jaatitkhaoula42/delishio/blob/main/delishio2.png?raw=true" width="260"/> </p>
📄 Description

Delishio is a modern Android cooking recipes application built using Kotlin, helping users easily discover, explore, and view detailed recipes.
The app offers a clean UI and integrates both remote API fetching and local storage for an enhanced experience.

🍲 Key Features

Browse a list of delicious recipes

View full recipe details (ingredients, instructions, image…)

Fast and responsive UI

Fetch data using Retrofit API

Store local data using Room Database

Elegant and user-friendly interface

MVVM clean architecture

🛠 Tech Stack

Language: Kotlin

Architecture: MVVM

Network: Retrofit + Gson

Local Storage: Room Database

UI: XML

Dependency Injection: Hilt (if added)

IDE: Android Studio

Build System: Gradle (KTS)

🌐 API Used

This project uses a public recipes API (such as Forkify API or similar).
It provides results including recipe title, ingredients, instructions, and images.

If you're using a specific API endpoint, you can add it here:

https://api.example.com/recipes

🗂️ Folder Structure
Delishio/
 ├── app/
 │   ├── data/
 │   │   ├── api/          # Retrofit API services
 │   │   ├── database/     # Room DAOs & Entities
 │   │   └── models/       # Data models
 │   ├── ui/
 │   │   ├── main/         # Recipe list screen
 │   │   └── detail/       # Recipe detail screen
 │   ├── utils/            # Helpers & extensions
 │   └── ...

📥 Installation & Running
git clone https://github.com/jaatitkhaoula42/delishio.git
cd delishio


Then open the project in Android Studio, sync Gradle, and click Run ▶.

🤝 Contributing

Pull requests are welcome!
If you want to improve the project, feel free to open an issue or submit a PR.

📄 License

This project is licensed under the MIT License.
