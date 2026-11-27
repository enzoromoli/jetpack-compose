package com.example.developprofileinteractive_devoir12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.developprofileinteractive_devoir12.ui.screen.ProfileContainer
import com.example.developprofileinteractive_devoir12.ui.theme.DeveloperProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeveloperProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileContainer(
                        onContactClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
