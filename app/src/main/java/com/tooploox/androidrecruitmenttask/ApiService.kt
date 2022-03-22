package com.tooploox.androidrecruitmenttask

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class ApiService {

    private val contentType = MediaType.get("application/json")
    private val json = Json {
        ignoreUnknownKeys = true
    }

    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://itunes.apple.com/")
        .addConverterFactory(
            json.asConverterFactory(contentType)
        )
        .build()

    val service: ItunesService = retrofit.create(ItunesService::class.java)
}
