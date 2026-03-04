package com.example.android_dolg.data

import com.example.android_dolg.domain.PeopleRepository
import com.example.android_dolg.domain.Person
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val api: GhibliApi
) : PeopleRepository {

    override suspend fun getPeople(): Result<List<Person>> =
        runCatching {
            api.getPeople().map { it.toDomain() }
        }

    override suspend fun getPersonById(id: String): Result<Person> =
        runCatching {
            api.getPersonById(id).toDomain()
        }

    private fun PersonDto.toDomain(): Person =
        Person(
            id = id,
            name = name,
            gender = gender ?: "Unknown",
            age = age ?: "Unknown",
            description = "Eye: ${eye_color ?: "-"} | Hair: ${hair_color ?: "-"}"
        )
}