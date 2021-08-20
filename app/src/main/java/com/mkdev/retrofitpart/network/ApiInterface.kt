package com.mkdev.retrofitpart.network

import com.mkdev.retrofitpart.models.QuoteModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/1.0/")
    fun getQuotes(
        @Query("method") method: String,
        @Query("format") format: String,
        @Query("lang") lan: String
    ): Call<QuoteModel>
}