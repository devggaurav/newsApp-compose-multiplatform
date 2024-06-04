package data

import domain.model.MainResponse
import domain.model.RequestState
import domain.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
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
          headers{
              append("X-Api-Key", apiKey)
          }
        }

    }

    override suspend fun getTopHeadline(): Flow<RequestState<MainResponse>> {
        TODO("Not yet implemented")
    }


    companion object{

        val baseUrl = "https://newsapi.org/v2/top-headlines?country=in"
        val apiKey = "f1ced744789e4137b0485b3e51749b48"
    }
}