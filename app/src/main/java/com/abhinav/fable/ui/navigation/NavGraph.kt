package com.abhinav.fable.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abhinav.fable.ThemeMode
import com.abhinav.fable.ui.screens.HomeScreen
import com.abhinav.fable.ui.screens.StoryDetailScreen
import com.abhinav.fable.viewmodel.StoryViewModel


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{storyId}") {
        fun createRoute(storyId: Int) = "detail/$storyId"
    }
}

@Composable
fun FableNavGraph(
    viewModel: StoryViewModel,
    currentTheme: ThemeMode,
    onThemeChange: (ThemeMode) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(400)) },
        exitTransition = { fadeOut(animationSpec = tween(400)) }
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                currentTheme = currentTheme,
                onThemeChange = onThemeChange,
                onStoryClick = { storyId ->
                    navController.navigate(Screen.Detail.createRoute(storyId))
                }
            )
        }

        // Story Detail Screen
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("storyId") {type = NavType.IntType }),
            // Opening animation
            enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) + fadeOut() }
        ) { backStackEntry ->

            val storyId = backStackEntry.arguments?.getInt("storyId") ?: return@composable

            StoryDetailScreen(
                storyId = storyId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToStory = { nextId ->


                    navController.navigate(Screen.Detail.createRoute(nextId)) {
                        popUpTo(Screen.Home.route) { inclusive = false }
                    }
                }
            )
        }
    }
}