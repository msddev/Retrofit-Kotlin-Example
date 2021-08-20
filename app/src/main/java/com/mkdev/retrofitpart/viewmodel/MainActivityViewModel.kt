package com.mkdev.retrofitpart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mkdev.retrofitpart.network.ApiResponse
import com.mkdev.retrofitpart.repository.ApiRepository

class MainActivityViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    private var quote: LiveData<ApiResponse>? = null

    fun getQuoteData(refresh: Boolean): LiveData<ApiResponse> {
        if (refresh) {
            quote = null
        }

        if (this.quote == null) {
            quote = apiRepository.getPosts()
        }

        return quote as LiveData<ApiResponse>
    }
}