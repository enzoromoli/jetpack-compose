package com.example.developprofileui_devoir08.data

import com.example.developprofileui_devoir08.model.DeveloperProfileUi
import com.example.developprofileui_devoir08.model.ProjectUi

fun sampleProfile(): DeveloperProfileUi {
    return DeveloperProfileUi(
        name = "Enzo Romoli",
        role = "Développeur Android junior",
        description = "Étudiant passionné par le développement mobile et Jetpack Compose, à la recherche d'un stage.",
        isAvailable = true,
        skills = listOf("Kotlin", "Jetpack Compose", "Material 3", "Git", "Android Studio"),
        projects = listOf(
            ProjectUi(
                title = "Greeting Card",
                description = "Première application Compose affichant une carte de vœux personnalisée.",
                stack = "Kotlin · Compose"
            ),
            ProjectUi(
                title = "Product Explorer",
                description = "Écrans d'accueil et de détail d'un catalogue de produits.",
                stack = "Kotlin · Compose · Material 3"
            ),
            ProjectUi(
                title = "Profil développeur",
                description = "Fiche de profil développeur avec composables réutilisables.",
                stack = "Kotlin · Compose"
            )
        ),
        email = "enzo.romoli@example.com",
        location = "Paris, France"
    )
}
