package presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import coil3.compose.AsyncImage
import domain.model.Articles
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.darkBlue
import ui.theme.onPrimaryContainerLight
import ui.theme.surfaceContainerLowestLight
import utils.getBoldFont
import utils.getRegularFont


//
// Created by Code For Android on 11/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

data class DetailsScreen(val article: Articles) : Screen {

    @Preview
    @Composable
    override fun Content() {


        Scaffold(
            topBar = {
                Text(
                    "Full Story",
                    color = surfaceContainerLowestLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    modifier = Modifier.padding(top = 90.dp, start = 16.dp),
                    fontFamily = getBoldFont()
                )
            },
            modifier = Modifier.fillMaxSize(),
            containerColor = onPrimaryContainerLight
        ) {


            Column(
                modifier = Modifier.padding(it)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth().height(300.dp).padding(16.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {

                    article.urlImage?.let {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize().clip(shape = RoundedCornerShape(20.dp)),
                            model = article.urlImage,
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }

                }

                article.author?.let { it1 ->
                    Text(
                        text = it1,
                        color = surfaceContainerLowestLight,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        modifier = Modifier.padding(top = 20.dp, start = 16.dp,end = 16.dp),
                        fontFamily = getBoldFont()
                    )
                }


                article.title?.let { it1 ->
                    Text(
                        text = it1,
                        color = surfaceContainerLowestLight,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 20.dp, start = 16.dp,end = 16.dp),
                        fontFamily = getRegularFont(),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                article.content?.let { it1 ->
                    Text(
                        text = it1,
                        color = surfaceContainerLowestLight,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 20.dp, start = 16.dp,end = 16.dp),
                        fontFamily = getRegularFont(),
                        overflow = TextOverflow.Ellipsis,
                    )
                }

            }

        }


    }
}