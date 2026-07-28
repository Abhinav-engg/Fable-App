package com.abhinav.fable.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.fable.data.Story
import com.abhinav.fable.data.StoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoryViewModel : ViewModel() {

    private val repository = StoryRepository()


    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories.asStateFlow()


    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        loadStories()
    }

    private fun loadStories() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            val result = repository.fetchStories()

            result.onSuccess { fetchedStories ->
                _stories.value = fetchedStories
                _uiState.value = UiState.Success
            }.onFailure { exception ->
                _uiState.value = UiState.Error(exception.message ?: "An unexpected error occurred.")
            }
        }
    }


    fun toggleFavorite(storyId: Int) {
        _stories.value = _stories.value.map { story ->
            if (story.id == storyId) {
                story.copy(isFavorite = !story.isFavorite)
            } else {
                story
            }
        }
    }


    fun getNextStoryId(currentId: Int): Int? {
        val currentIndex = _stories.value.indexOfFirst { it.id == currentId }
        return if (currentIndex != -1 && currentIndex < _stories.value.size - 1) {
            _stories.value[currentIndex + 1].id
        } else null
    }


    fun getPreviousStoryId(currentId: Int): Int? {
        val currentIndex = _stories.value.indexOfFirst { it.id == currentId }
        return if (currentIndex > 0) {
            _stories.value[currentIndex - 1].id
        } else null
    }
}