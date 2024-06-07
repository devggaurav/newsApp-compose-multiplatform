package data

import domain.model.Articles
import domain.model.MainResponse
import domain.model.RequestState
import domain.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json


//
// Created by Code For Android on 04/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class ApiServiceImpl : ApiService {


    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000
        }
        install(DefaultRequest) {
            headers {
                append("X-Api-Key", API_KEY)
            }
        }

    }

    override suspend fun getTopHeadline(): Flow<RequestState<List<Articles?>>> {
        return flow {
            try {
                 emit(RequestState.Loading)
                val response = httpClient.get(BASE_URL)
                if (response.status.value == 200) {
                    val json = Json { ignoreUnknownKeys = true }
                    val apiResponse = json.decodeFromString<MainResponse>(response.body())
                     print(apiResponse)
                    val articles = apiResponse.articles
                    emit(RequestState.Success(articles))
                } else {
                    emit(RequestState.Error("Something went wrong ${response.status}"))
                }
            } catch (ex: Exception) {
                emit(RequestState.Error(ex.message.toString()))
            }
        }
    }


    companion object {

        const val BASE_URL = "https://newsapi.org/v2/top-headlines?country=in"
        const val API_KEY = "f1ced744789e4137b0485b3e51749b48"

    }
}