package com.example.developprofileinteractive_devoir12.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developprofileinteractive_devoir12.data.sampleProfile
import com.example.developprofileinteractive_devoir12.model.DeveloperProfileUi
import com.example.developprofileinteractive_devoir12.model.ProjectUi
import com.example.developprofileinteractive_devoir12.ui.component.ContactSection
import com.example.developprofileinteractive_devoir12.ui.component.ProfileHeader
import com.example.developprofileinteractive_devoir12.ui.component.ProjectCard
import com.example.developprofileinteractive_devoir12.ui.component.SkillsSection
import com.example.developprofileinteractive_devoir12.ui.theme.DeveloperProfileTheme

@Composable
fun ProfileScreen(
    profile: DeveloperProfileUi,
    projects: List<ProjectUi>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    showOnlyFavorites: Boolean,
    onToggleFavoriteFilter: () -> Unit,
    favoriteProjectIds: List<Int>,
    onFavoriteClick: (Int) -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                description = profile.description,
                isAvailable = profile.isAvailable
            )
        }
        item {
            SkillsSection(skills = profile.skills)
        }
        item {
            Text(
                text = "Projets",
                style = MaterialTheme.typography.titleMedium
            )
        }
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                label = {
                    Text(text = "Rechercher un projet ou une technologie")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Button(onClick = onToggleFavoriteFilter) {
                Text(
                    text = if (showOnlyFavorites) {
                        "Afficher tous les projets"
                    } else {
                        "Afficher uniquement les favoris"
                    }
                )
            }
        }
        item {
            Text(
                text = if (projects.size > 1) {
                    "${projects.size} projets affichés"
                } else {
                    "${projects.size} projet affiché"
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
        items(projects, key = { it.id }) { project ->
            ProjectCard(
                project = project,
                isFavorite = favoriteProjectIds.contains(project.id),
                onFavoriteClick = {
                    onFavoriteClick(project.id)
                }
            )
        }
        item {
            ContactSection(
                email = profile.email,
                location = profile.location,
                availability = profile.availability,
                onContactClick = onContactClick
            )
        }
    }
}

@Preview(name = "Clair - tous les projets", showBackground = true)
@Composable
fun ProfileScreenAllProjectsPreview() {
    val profile = sampleProfile()
    DeveloperProfileTheme(darkTheme = false) {
        ProfileScreen(
            profile = profile,
            projects = profile.projects,
            searchQuery = "",
            onSearchQueryChange = {},
            showOnlyFavorites = false,
            onToggleFavoriteFilter = {},
            favoriteProjectIds = emptyList(),
            onFavoriteClick = {},
            onContactClick = {}
        )
    }
}

@Preview(
    name = "Sombre - recherche et favoris",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileScreenFavoritesSearchPreview() {
    val profile = sampleProfile()
    val favoriteIds = listOf(1, 2)
    DeveloperProfileTheme(darkTheme = true) {
        ProfileScreen(
            profile = profile,
            projects = profile.projects.filter { it.id in favoriteIds },
            searchQuery = "Kotlin",
            onSearchQueryChange = {},
            showOnlyFavorites = true,
            onToggleFavoriteFilter = {},
            favoriteProjectIds = favoriteIds,
            onFavoriteClick = {},
            onContactClick = {}
        )
    }
}
