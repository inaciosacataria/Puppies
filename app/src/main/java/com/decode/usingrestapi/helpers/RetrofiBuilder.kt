package com.decode.usingrestapi.helpers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofiBuilder {

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Contants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}