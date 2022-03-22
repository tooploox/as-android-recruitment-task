package com.tooploox.androidrecruitmenttask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val apiService = ApiService()

    private val _songs: MutableStateFlow<List<Song>> = MutableStateFlow(emptyList())
    val songs: StateFlow<List<Song>> = _songs

    init {
        viewModelScope.launch {
            _songs.value = apiService.service.getSongs("post malone", 30).songs.map { Song(it.trackName, it.artist) }
        }
    }
}
