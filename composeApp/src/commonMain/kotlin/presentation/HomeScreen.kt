package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import domain.model.RequestState
import ui.theme.darkBlue
import ui.theme.primaryContainerDark
import ui.theme.primaryContainerLight
import ui.theme.primaryLight
import ui.theme.surfaceContainerLowestLight
import utils.getBoldFont


//
// Created by Code For Android on 04/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = getScreenModel<NewsViewModel>()

        val news = viewModel.news

        Scaffold(
            containerColor = darkBlue,
            topBar = {
                Text(
                    "Top HeadLines",
                    color = surfaceContainerLowestLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    modifier = Modifier.padding(top = 90.dp, start = 16.dp),
                    fontFamily = getBoldFont()
                )
            },


        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {

                when (news.value) {
                    is RequestState.Error -> {}
                    RequestState.Idle -> {}
                    RequestState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
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
}