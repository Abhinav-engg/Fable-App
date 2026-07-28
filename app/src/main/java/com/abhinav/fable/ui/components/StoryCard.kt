package com.abhinav.fable.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abhinav.fable.data.Story
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun StoryCard(
    story: Story,
    onStoryClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onStoryClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {

                Image(
                    painter = painterResource(id = story.coverImages),
                    contentDescription = "Cover image for ${story.title}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Black.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = story.category,
                            color = MaterialTheme.colorScheme.primary, // Gold color
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    IconButton(
                        onClick = onFavoriteClick,
                        modifier = Modifier
                            .background(
                                color = Color.Black.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(50)
                            )
                            .size(36.dp)
                    ) {
                        Icon(
                            imageVector = if (story.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Toggle Favorite",
                            tint = if (story.isFavorite) MaterialTheme.colorScheme.primary else Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = "by ${story.author}  •  ${story.readTime}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )



                Text(
                    text = story.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 8.dp)
                )



                Text(
                    text = story.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 16.dp)
                )




                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Read story",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "→",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun StoryCardPreview(
//) {
//
//    FableTheme {
//        StoryCard(
//            story = Story(
//                id = 1,
//                title = "The Whispering Wood",
//                author = "Elara Voss",
//                readTime = "8 min read",
//                category = "MYSTERY",
//                description = "A solitary wanderer discovers that the ancient forest holds memories older than language itself.",
//                content = listOf("Hola"),
//                coverImages = android.R.drawable.ic_menu_gallery,
//                isFavorite = false
//            ),
//            onStoryClick = {},
//            onFavoriteClick = {}
//        )
//    }
//}