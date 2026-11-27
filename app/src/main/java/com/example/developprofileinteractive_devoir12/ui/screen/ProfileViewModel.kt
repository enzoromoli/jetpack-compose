package com.example.developprofileinteractive_devoir12.ui.screen

import androidx.lifecycle.ViewModel
import com.example.developprofileinteractive_devoir12.data.sampleProfile
import com.example.developprofileinteractive_devoir12.model.DeveloperProfileUi
import com.example.developprofileinteractive_devoir12.model.ProjectUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val profile: DeveloperProfileUi = sampleProfile()

    private val _uiState = MutableStateFlow(
        ProfileUiState(
            profile = profile,
            projects = profile.projects
        )
    )

    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private fun filterProjects(
        searchQuery: String,
        showOnlyFavorites: Boolean,
        favoriteProjectIds: List<Int>
    ): List<ProjectUi> {
        return profile.projects.filter { project ->
            val matchesSearch =
                project.title.contains(searchQuery, ignoreCase = true) ||
                        project.description.contains(searchQuery, ignoreCase = true) ||
                        project.technologies.any { it.contains(searchQuery, ignoreCase = true) }

            val matchesFavorite =
                !showOnlyFavorites || favoriteProjectIds.contains(project.id)

            matchesSearch && matchesFavorite
        }
    }

    fun onSearchQueryChange(newValue: String) {
        _uiState.update { currentState ->
            currentState.copy(
                searchQuery = newValue,
                projects = filterProjects(
                    searchQuery = newValue,
                    showOnlyFavorites = currentState.showOnlyFavorites,
                    favoriteProjectIds = currentState.favoriteProjectIds
                )
            )
        }
    }

    fun onToggleFavoriteFilter() {
        _uiState.update { currentState ->
            val newShowOnlyFavorites = !currentState.showOnlyFavorites

            currentState.copy(
                showOnlyFavorites = newShowOnlyFavorites,
                projects = filterProjects(
                    searchQuery = currentState.searchQuery,
                    showOnlyFavorites = newShowOnlyFavorites,
                    favoriteProjectIds = currentState.favoriteProjectIds
                )
            )
        }
    }

    fun onFavoriteClick(projectId: Int) {
        _uiState.update { currentState ->
            val newFavoriteIds =
                if (currentState.favoriteProjectIds.contains(projectId)) {
                    currentState.favoriteProjectIds - projectId
                } else {
                    currentState.favoriteProjectIds + projectId
                }

            currentState.copy(
                favoriteProjectIds = newFavoriteIds,
                projects = filterProjects(
                    searchQuery = currentState.searchQuery,
                    showOnlyFavorites = currentState.showOnlyFavorites,
                    favoriteProjectIds = newFavoriteIds
                )
            )
        }
    }
}
