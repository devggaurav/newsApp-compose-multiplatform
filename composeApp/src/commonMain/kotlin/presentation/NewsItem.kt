package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import domain.model.Articles
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.outlineLight
import utils.getBoldFont
import utils.getRegularFont


//
// Created by Code For Android on 05/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun NewsItem(article: Articles) {


    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
        ) {

            article.urlImage?.let {
                AsyncImage(
                    modifier = Modifier
                        .size(120.dp).clip(shape = RoundedCornerShape(10.dp)),
                    model = article.urlImage,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }


            article.title?.let {
                Text(
                    it,
                    maxLines = 3,
                    fontSize = 17.sp,
                    fontFamily = getBoldFont(),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        top = 8.dp,
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 8.dp
                    ),
                    color = Color.White
                )
            }


        }

    }


}