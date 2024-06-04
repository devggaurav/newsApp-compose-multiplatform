package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//
// Created by Code For Android on 04/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Serializable
data class MainResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)

@Serializable
data class Articles(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    @SerialName("urlToImage")
    val urlImage: String,
    val publishedAt: String,
    val content: String
)


@Serializable
data class Source(
    val id: String,
    val name: String

)