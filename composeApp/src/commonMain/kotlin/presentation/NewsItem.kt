package presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.Articles
import org.jetbrains.compose.ui.tooling.preview.Preview


//
// Created by Code For Android on 05/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun NewsItem(article: Articles) {

    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        article.title?.let {
            Text(it)
        }


    }


}