package domain.remote

import domain.model.MainResponse
import domain.model.RequestState
import kotlinx.coroutines.flow.Flow


//
// Created by Code For Android on 04/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

interface ApiService {

    suspend fun getTopHeadline(): Flow<RequestState<MainResponse>>
}