package com.ankurkushwaha.akcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Ankur Kushwaha
 * Created on 15/06/2025 at 07:53
 */

@Composable
fun ComposeCard(modifier: Modifier = Modifier) {
    // List of colors to cycle through
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Cyan,
        Color.Magenta
    )

    // Track the current index
    var currentIndex by remember { mutableStateOf(0) }

    // Update background color based on the current index
    val backgroundColor = colors[currentIndex]

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                // Increment the index and loop back if at end
                currentIndex = (currentIndex + 1) % colors.size
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Click Me!",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
    }
}
