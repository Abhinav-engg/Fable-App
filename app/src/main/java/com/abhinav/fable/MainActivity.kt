package com.abhinav.fable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhinav.fable.ui.navigation.FableNavGraph
import com.abhinav.fable.ui.theme.FableTheme
import com.abhinav.fable.viewmodel.StoryViewModel
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*

enum class ThemeMode { SYSTEM, LIGHT, DARK }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var themeMode by remember { mutableStateOf(ThemeMode.SYSTEM) }


            val isSystemDark = isSystemInDarkTheme()
            val darkTheme = when (themeMode) {
                ThemeMode.SYSTEM -> isSystemDark
                ThemeMode.LIGHT -> false
                ThemeMode.DARK -> true
            }


            FableTheme(darkTheme = darkTheme) {
                val viewModel: StoryViewModel = viewModel()


                FableNavGraph(
                    viewModel = viewModel,
                    currentTheme = themeMode,
                    onThemeChange = { themeMode = it }
                )
            }
        }
    }
}