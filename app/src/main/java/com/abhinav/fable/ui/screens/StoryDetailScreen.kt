package com.abhinav.fable.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.fable.viewmodel.StoryViewModel

@Composable
fun StoryDetailScreen(
    storyId: Int,
    viewModel: StoryViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToStory: (Int) -> Unit
) {

    val stories by viewModel.stories.collectAsState()
    val story = stories.find { it.id == storyId }


    if (story == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Story not found.", color = MaterialTheme.colorScheme.error)
        }
        return
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            Image(
                painter = painterResource(id = story.coverImages),
                contentDescription = "Cover for ${story.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .statusBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(50))
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }

                IconButton(
                    onClick = { viewModel.toggleFavorite(story.id) },
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(50))
                ) {
                    Icon(
                        imageVector = if (story.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (story.isFavorite) MaterialTheme.colorScheme.primary else Color.White
                    )
                }
            }
        }




        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Text(
                text = "${story.category}  •  ${story.readTime}",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = story.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "by ${story.author}",
                color = MaterialTheme.colorScheme.primary,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(32.dp))


            story.content.forEach { paragraph ->
                Text(
                    text = paragraph,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Divider(color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f))
            Spacer(modifier = Modifier.height(32.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val prevId = viewModel.getPreviousStoryId(story.id)
                val nextId = viewModel.getNextStoryId(story.id)

                // Previous Button
                if (prevId != null) {
                    OutlinedButton(
                        onClick = { onNavigateToStory(prevId) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
                    ) {
                        Text("← Previous")
                    }
                } else {
                    Spacer(modifier = Modifier.width(8.dp)) // Keeps layout balanced if no prev button
                }

                // Next Button
                if (nextId != null) {
                    OutlinedButton(
                        onClick = { onNavigateToStory(nextId) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
                    ) {
                        Text("Next →")
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}