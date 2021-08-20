package com.mkdev.retrofitpart.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkdev.retrofitpart.models.QuoteModel
import com.mkdev.retrofitpart.network.ApiClient
import com.mkdev.retrofitpart.network.ApiInterface
import com.mkdev.retrofitpart.network.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {

    fun getPosts(): LiveData<ApiResponse> {
        val apiResponse = MutableLiveData<ApiResponse>()
        val apiService = ApiClient().getClient()!!.create(ApiInterface::class.java)
        val apiCall: Call<QuoteModel> = apiService.getQuotes("getQuote", "json", "en")
        apiCall.enqueue(object : Callback<QuoteModel> {
            override fun onResponse(call: Call<QuoteModel>, response: Response<QuoteModel>) {
                // postValue() called from a background thread
                if (response.isSuccessful) {
                    apiResponse.postValue(ApiResponse(response.body()))
                } else {
                    apiResponse.postValue(ApiResponse(response.code()))
                }
            }

            override fun onFailure(call: Call<QuoteModel>, t: Throwable) {
                apiResponse.postValue(ApiResponse(t))
            }
        })

        return apiResponse
    }
}