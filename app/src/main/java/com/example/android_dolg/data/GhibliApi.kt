package com.example.android_dolg.data

import retrofit2.http.GET
import retrofit2.http.Path

interface GhibliApi {

    @GET("people")
    suspend fun getPeople(): List<PersonDto>

    @GET("people/{id}")
    suspend fun getPersonById(
        @Path("id") id: String
    ): PersonDto
}