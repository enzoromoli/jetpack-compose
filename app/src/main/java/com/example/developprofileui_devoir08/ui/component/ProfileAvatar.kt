package com.example.developprofileui_devoir08.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun ProfileAvatar(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            imageVector = Icons.Filled.Person,
            contentDescription = "Avatar",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
        )
        if (isAvailable) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Disponible",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(28.dp)
                    .background(MaterialTheme.colorScheme.surface, CircleShape)
            )
        }
    }
}
