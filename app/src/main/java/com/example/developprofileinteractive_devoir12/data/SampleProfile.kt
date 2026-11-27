package com.example.developprofileinteractive_devoir12.data

import com.example.developprofileinteractive_devoir12.model.DeveloperProfileUi
import com.example.developprofileinteractive_devoir12.model.ProjectUi

fun sampleProfile(): DeveloperProfileUi {
    return DeveloperProfileUi(
        name = "Enzo Romoli",
        role = "Développeur Android junior",
        description = "Étudiant passionné par le développement mobile et Jetpack Compose, à la recherche d'un stage.",
        isAvailable = true,
        availability = "Disponible pour un stage",
        skills = listOf("Kotlin", "Jetpack Compose", "Material 3", "Git", "Android Studio"),
        projects = listOf(
            ProjectUi(
                id = 1,
                title = "Greeting Card",
                description = "Première application Compose affichant une carte de vœux personnalisée.",
                technologies = listOf("Kotlin", "Compose")
            ),
            ProjectUi(
                id = 2,
                title = "Product Explorer",
                description = "Catalogue de produits avec recherche, filtres, favoris, ViewModel et StateFlow.",
                technologies = listOf("Kotlin", "Compose", "Material 3", "ViewModel", "StateFlow")
            ),
            ProjectUi(
                id = 3,
                title = "Profil développeur",
                description = "Fiche de profil développeur avec composables réutilisables.",
                technologies = listOf("Kotlin", "Compose", "Material 3")
            ),
            ProjectUi(
                id = 4,
                title = "Site portfolio",
                description = "Site web personnel présentant mes projets et mon parcours.",
                technologies = listOf("HTML", "CSS", "JavaScript")
            )
        ),
        email = "enzo.romoli@example.com",
        location = "Paris, France"
    )
}
