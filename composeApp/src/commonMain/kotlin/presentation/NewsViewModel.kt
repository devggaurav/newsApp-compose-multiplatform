package presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.model.Articles
import domain.model.RequestState
import domain.remote.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


//
// Created by Code For Android on 05/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class NewsViewModel(
    private val newsRepository: ApiService
) : ScreenModel {


    private val _news: MutableState<RequestState<List<Articles?>>> =
        mutableStateOf(RequestState.Idle)
    val news: State<RequestState<List<Articles?>>> = _news


    init {
        getNews()
    }

    private fun getNews() {

        screenModelScope.launch {

            newsRepository.getTopHeadline().let {
                it.collectLatest {

                    _news.value = it

                }
            }


        }


    }

}