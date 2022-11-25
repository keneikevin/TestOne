package com.example.testone.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testone.data.remote.response.ComicsResponse
import com.example.testone.data.remote.response.WordInfoDto
import com.example.testone.domain.mappers.CharacterInfo
import com.example.testone.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WordInfoRepositoryImpl
) : ViewModel() {
    private val _comicStatus = MutableLiveData<Resource<ComicsResponse>>()
    val comicStatus: LiveData<Resource<ComicsResponse>> = _comicStatus

    private var _comics: MutableLiveData<List<WordInfoDto>> = MutableLiveData<List<WordInfoDto>>()
    var comics: LiveData<List<WordInfoDto>> = _comics

    private var _word: MutableLiveData<List<CharacterInfo>> = MutableLiveData<List<CharacterInfo>>()
    var word: LiveData<List<CharacterInfo>> = _word

    private var _series: MutableLiveData<List<CharacterInfo>> = MutableLiveData<List<CharacterInfo>>()
    var series: LiveData<List<CharacterInfo>> = _series

    private var _stories: MutableLiveData<List<CharacterInfo>> = MutableLiveData<List<CharacterInfo>>()
    var stories: LiveData<List<CharacterInfo>> = _stories



    fun getComics() {

        viewModelScope.launch {
            val response= repository.getAllCharacters()
            _word.value = response

            Log.d("getComics",response.toString())
            Log.d("_comics",_comics.value.toString())
        }
    }


    fun getSeries() {
        viewModelScope.launch {
            val response= repository.getSeriesCharacters()
            _series.value = response
            Log.d("getComics",response.toString())
        }
    }

    fun getStories() {
        viewModelScope.launch {
            val response= repository.getStoriesCharacters()
            _stories.value = response
            Log.d("getComics",response.toString())
        }
    }




}