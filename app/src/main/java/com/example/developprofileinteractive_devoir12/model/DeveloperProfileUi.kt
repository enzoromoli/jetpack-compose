package com.example.developprofileinteractive_devoir12.model

data class DeveloperProfileUi(
    val name: String,
    val role: String,
    val description: String,
    val isAvailable: Boolean,
    val skills: List<String>,
    val projects: List<ProjectUi>,
    val email: String,
    val location: String
)
