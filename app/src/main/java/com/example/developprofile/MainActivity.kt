package com.example.developprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DeveloperProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DeveloperProfileScreen(modifier: Modifier = Modifier) {
    DeveloperProfileCard(
        name = "Enzo Romoli",
        role = "Développeur Android junior",
        description = "Étudiant passionné par le développement mobile et Jetpack Compose.",
        skills = listOf("Kotlin", "Jetpack Compose", "Git", "Android Studio"),
        availability = "Disponible pour un stage",
        actionLabel = "Contacter",
        onActionClick = {},
        onAvailabilityClick = {},
        modifier = modifier.padding(24.dp)
    )
}

@Composable
fun DeveloperProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    availability: String,
    actionLabel: String,
    onActionClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            ProfileHeader(name = name, role = role)
            ProfileDescription(
                description = description,
                modifier = Modifier.padding(top = 8.dp)
            )
            skills.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            AvailabilityBanner(
                text = availability,
                onClick = onAvailabilityClick,
                modifier = Modifier.padding(top = 12.dp)
            )
            ContactAction(
                label = actionLabel,
                onClick = onActionClick,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}

@Composable
fun ProfileHeader(name: String, role: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = role)
    }
}

@Composable
fun ProfileDescription(description: String, modifier: Modifier = Modifier) {
    Text(text = description, modifier = modifier)
}

@Composable
fun SkillItem(skill: String, modifier: Modifier = Modifier) {
    Text(text = "• $skill", modifier = modifier)
}

@Composable
fun AvailabilityBanner(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .semantics {
                role = Role.Button
                contentDescription = "Disponibilité : $text"
            }
    ) {
        Text(text = text, modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun ContactAction(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = label)
    }
}

@Preview(showBackground = true)
@Composable
fun DeveloperProfileAndroidJuniorPreview() {
    GreetingCardTheme {
        DeveloperProfileCard(
            name = "Enzo Romoli",
            role = "Développeur Android junior",
            description = "Étudiant passionné par Jetpack Compose.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git"),
            availability = "Disponible pour un stage",
            actionLabel = "Contacter",
            onActionClick = {},
            onAvailabilityClick = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DeveloperProfileFullStackPreview() {
    GreetingCardTheme {
        DeveloperProfileCard(
            name = "Alice Martin",
            role = "Développeuse full-stack",
            description = "Freelance expérimentée en projets web et mobile.",
            skills = listOf("TypeScript", "React", "Node.js", "Kotlin"),
            availability = "Indisponible actuellement",
            actionLabel = "Voir le portfolio",
            onActionClick = {},
            onAvailabilityClick = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}
