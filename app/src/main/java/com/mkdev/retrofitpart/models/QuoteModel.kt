package com.mkdev.retrofitpart.models

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("quoteText")
    val quoteText: String? = null,
    @SerializedName("quoteAuthor")
    val quoteAuthor: String? = null
)