package com.example.developprofileinteractive_devoir12.ui.screen

import com.example.developprofileinteractive_devoir12.model.DeveloperProfileUi
import com.example.developprofileinteractive_devoir12.model.ProjectUi

data class ProfileUiState(
    val profile: DeveloperProfileUi,
    val projects: List<ProjectUi> = emptyList(),
    val searchQuery: String = "",
    val showOnlyFavorites: Boolean = false,
    val favoriteProjectIds: List<Int> = emptyList()
)
