package com.example.android_dolg.domain

interface PeopleRepository {

    suspend fun getPeople(): Result<List<Person>>

    suspend fun getPersonById(id: String): Result<Person>
}