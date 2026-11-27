package com.example.developprofileinteractive_devoir12.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developprofileinteractive_devoir12.data.sampleProfile
import com.example.developprofileinteractive_devoir12.model.DeveloperProfileUi
import com.example.developprofileinteractive_devoir12.ui.component.ContactSection
import com.example.developprofileinteractive_devoir12.ui.component.ProfileHeader
import com.example.developprofileinteractive_devoir12.ui.component.ProjectCard
import com.example.developprofileinteractive_devoir12.ui.component.SkillsSection
import com.example.developprofileinteractive_devoir12.ui.theme.DeveloperProfileTheme

@Composable
fun DeveloperProfileScreen(
    profile: DeveloperProfileUi,
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
        items(profile.projects, key = { it.title }) { project ->
            ProjectCard(project = project)
        }
        item {
            ContactSection(
                email = profile.email,
                location = profile.location,
                onContactClick = onContactClick
            )
        }
    }
}

@Preview(name = "Clair", showBackground = true)
@Composable
fun DeveloperProfileScreenLightPreview() {
    DeveloperProfileTheme(darkTheme = false) {
        DeveloperProfileScreen(
            profile = sampleProfile(),
            onContactClick = {}
        )
    }
}

@Preview(name = "Sombre", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeveloperProfileScreenDarkPreview() {
    DeveloperProfileTheme(darkTheme = true) {
        DeveloperProfileScreen(
            profile = sampleProfile(),
            onContactClick = {}
        )
    }
}
