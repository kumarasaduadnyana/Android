package com.android.usergithub.api

import com.android.usergithub.ListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Services {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun searchUserList(
        @Query("q") q:String?
    ):Call<ListData>
}