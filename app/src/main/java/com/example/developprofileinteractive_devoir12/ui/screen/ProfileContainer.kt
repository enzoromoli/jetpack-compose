package com.example.developprofileinteractive_devoir12.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileContainer(
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreen(
        profile = uiState.profile,
        projects = uiState.projects,
        searchQuery = uiState.searchQuery,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        showOnlyFavorites = uiState.showOnlyFavorites,
        onToggleFavoriteFilter = viewModel::onToggleFavoriteFilter,
        favoriteProjectIds = uiState.favoriteProjectIds,
        onFavoriteClick = viewModel::onFavoriteClick,
        onContactClick = onContactClick,
        modifier = modifier
    )
}
