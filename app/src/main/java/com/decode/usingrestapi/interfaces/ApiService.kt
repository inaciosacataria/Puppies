package com.decode.usingrestapi.interfaces

import com.decode.usingrestapi.repositories.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface  ApiService {
    @GET
    suspend fun getByBreed (@Url url : String): Response<DogResponse>

}

