package com.abhinav.fable.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.fable.ui.components.StoryCard
import com.abhinav.fable.viewmodel.StoryViewModel
import com.abhinav.fable.viewmodel.UiState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.SettingsSystemDaydream
import com.abhinav.fable.ThemeMode
@Composable
fun HomeScreen(
    viewModel: StoryViewModel,
    currentTheme: ThemeMode,
    onThemeChange: (ThemeMode) -> Unit,
    onStoryClick: (Int) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val stories by viewModel.stories.collectAsState()


    var showFavoritesOnly by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("All") }


    val categories = listOf("All") + stories.map { it.category }.distinct()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            HomeTopBar(
                showFavoritesOnly = showFavoritesOnly,
                onToggleFavorites = { showFavoritesOnly = it },
                currentTheme = currentTheme,
                onThemeChange = onThemeChange
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {


            when (uiState) {
                is UiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                is UiState.Error -> {
                    val errorMessage = (uiState as UiState.Error).message
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
                is UiState.Success -> {
                    // filtering stories based on fav and categories
                    val displayStories = stories.filter { story ->
                        val matchesFavorite = if (showFavoritesOnly) story.isFavorite else true
                        val matchesCategory = if (selectedCategory == "All") true else story.category.equals(selectedCategory, ignoreCase = true)

                        matchesFavorite && matchesCategory
                    }


                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 24.dp)
                    ) {
                        item {
                            HomeHeader()
                        }


                        item {
                            CategoryFilterRow(
                                categories = categories,
                                selectedCategory = selectedCategory,
                                onCategorySelected = { selectedCategory = it }
                            )
                        }

// no fav text
                        if (displayStories.isEmpty() && showFavoritesOnly) {
                            item {
                                Text(
                                    text = "No favorites yet. Start exploring!",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(top = 32.dp)
                                )
                            }
                        } else {
                            items(displayStories, key = { it.id }) { story ->
                                StoryCard(
                                    story = story,
                                    onStoryClick = { onStoryClick(story.id) },
                                    onFavoriteClick = { viewModel.toggleFavorite(story.id) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun HomeTopBar(
    showFavoritesOnly: Boolean,
    onToggleFavorites: (Boolean) -> Unit,
    currentTheme: ThemeMode,
    onThemeChange: (ThemeMode) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Fable Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Fable",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.width(8.dp))

            // theme toggle button
            IconButton(onClick = {
                val nextTheme = when (currentTheme) {
                    ThemeMode.SYSTEM -> ThemeMode.LIGHT
                    ThemeMode.LIGHT -> ThemeMode.DARK
                    ThemeMode.DARK -> ThemeMode.SYSTEM
                }
                onThemeChange(nextTheme)
            }) {
                val icon = when (currentTheme) {
                    ThemeMode.SYSTEM -> Icons.Filled.SettingsSystemDaydream
                    ThemeMode.LIGHT -> Icons.Filled.LightMode
                    ThemeMode.DARK -> Icons.Filled.DarkMode
                }
                Icon(
                    imageVector = icon,
                    contentDescription = "Toggle Theme",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Row(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(4.dp)
        ) {
            TabButton(text = "Stories", isSelected = !showFavoritesOnly) { onToggleFavorites(false) }
            TabButton(text = "Favorites", isSelected = showFavoritesOnly) { onToggleFavorites(true) }
        }
    }
}

@Composable
fun TabButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.background else Color.Transparent
    val textColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun HomeHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 24.dp)
    ) {
        Text(
            text = "A COLLECTION OF TALES",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium,
            letterSpacing = 1.5.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Stories Worth",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Remembering",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Divider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(10.dp)
            )
            Divider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}
@Composable
fun CategoryFilterRow(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory



            FilterChip(
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                label = {
                    Text(
                        text = category,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    selectedLabelColor = MaterialTheme.colorScheme.primary,
                    labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                shape = RoundedCornerShape(50)
            )
        }
    }
}