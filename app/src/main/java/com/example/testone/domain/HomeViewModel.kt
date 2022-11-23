package com.example.testone.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testone.data.remote.response.CharacterDetail.CharacterDetailResponse
import com.example.testone.data.remote.response.CharacterDetail.ResultDetail
import com.example.testone.data.remote.response.comics.ComicsResponse
import com.example.testone.data.remote.response.comics.Result
import com.example.testone.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(

    private val repository: HomeRepository
) : ViewModel() {
    private val _comicStatus = MutableLiveData<Resource<ComicsResponse>>()
    val comicStatus: LiveData<Resource<ComicsResponse>> = _comicStatus
    private var _comics: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()
    var comics: LiveData<List<Result>> = _comics

  private val _comicDetailStatus = MutableLiveData<Resource<CharacterDetailResponse>>()
    val comicDetailStatus: LiveData<Resource<CharacterDetailResponse>> = _comicDetailStatus
    private var _comicDetail: MutableLiveData<List<ResultDetail>> = MutableLiveData<List<ResultDetail>>()
    var comicDetail: LiveData<List<ResultDetail>> = _comicDetail


    fun getComics() {
        viewModelScope.launch {
            val response= repository.getComics()
            _comics.value = response.data?.data?.results

            Log.d("getComics",response.data.toString())
            Log.d("_comics",_comics.value.toString())
        }
    }
    fun getComicDetails() {
        viewModelScope.launch {
            val response= repository.getComicDetails("82967")
            _comicDetail.value = response.data?.data?.results

            Log.d("ComicsDetail",response.data.toString())
            Log.d("_detail",_comicDetail.value.toString())
        }
    }

    fun getSeries() {
        viewModelScope.launch {
            val response= repository.getSeries()
            _comics.value = response.data?.data?.results
            Log.d("getComics",response.data.toString())
            Log.d("_comics",_comics.value.toString())
        }
    }

    fun getStories() {
        viewModelScope.launch {
            val response= repository.getStories()
            _comics.value = response.data?.data?.results

            Log.d("getComics",response.data.toString())
            Log.d("_comics",_comics.value.toString())
        }
    }




}