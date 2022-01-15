package com.example.kotlinnews.ui.newsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinnews.models.NewsResponse
import com.example.myapplication.network.RetrofitHandler
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.launch

class NewsListViewModel : ViewModel(){

    private val _newsLiveData= MutableLiveData<Resource<NewsResponse>>()
    val newsLiveData: LiveData<Resource<NewsResponse>> get() = _newsLiveData


    init {
        getAllNews()
    }

    private fun getAllNews() {
        _newsLiveData.value=Resource.loading()
        viewModelScope.launch{
            val  response=RetrofitHandler.getWebService().getAllNews()
            if (response.isSuccessful)
            {
                _newsLiveData.value=Resource.success(response.body()!!)
            }
            else
            {
               _newsLiveData.value=Resource.error(response.errorBody().toString())
            }
        }
    }

}