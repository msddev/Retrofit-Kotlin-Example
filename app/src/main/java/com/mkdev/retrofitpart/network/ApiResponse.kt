package com.mkdev.retrofitpart.network

import com.mkdev.retrofitpart.models.QuoteModel

class ApiResponse {

    var posts: QuoteModel? = null
    var error: Throwable? = null
    var code: Int? = null

    constructor(posts: QuoteModel?) {
        this.posts = posts
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.posts = null
    }

    constructor(code: Int?) {
        this.code = code
    }
}