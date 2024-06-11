package utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import newsapp.composeapp.generated.resources.Res
import newsapp.composeapp.generated.resources.oldStandardTT_Bold
import newsapp.composeapp.generated.resources.oldStandardTT_Regular
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font


//
// Created by Code For Android on 11/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun getRegularFont(): FontFamily = FontFamily(Font(Res.font.oldStandardTT_Regular))

@Composable
fun getBoldFont(): FontFamily = FontFamily(Font(Res.font.oldStandardTT_Bold))