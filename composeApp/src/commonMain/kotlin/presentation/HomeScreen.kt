package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import domain.model.RequestState


//
// Created by Code For Android on 04/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = getScreenModel<NewsViewModel>()

        val news = viewModel.news


        Column(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {

            when (news.value) {
                is RequestState.Error -> {}
                RequestState.Idle -> {}
                RequestState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                is RequestState.Success -> {
                    val articles = news.value.getSuccessData()

                    LazyColumn {

                        items(articles) {
                            it?.let {
                                NewsItem(it)
                            }
                        }
                    }
                }
            }


        }


    }
}