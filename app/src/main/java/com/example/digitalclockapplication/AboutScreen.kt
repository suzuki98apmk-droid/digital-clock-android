package com.example.digitalclockapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutScreen(
    onBack: () -> Unit
) {

    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .background(
                    Color(0xFF101010)
                )
                .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {


        /*
         * アプリ名
         */
        Text(

            text = "Digital Clock",

            fontSize = 32.sp,

            color =
                Color.White
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        /*
         * バージョン
         */
        Text(

            text = "Version 1.0.0",

            fontSize = 16.sp,

            color =
                Color(0xFFAAAAAA)
        )


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        /*
         * 説明
         */
        Text(

            text =
                "シンプルで見やすい\nデジタル時計アプリ",

            fontSize = 18.sp,

            color =
                Color.White
        )


        Spacer(
            modifier =
                Modifier.height(40.dp)
        )


        /*
         * 戻る
         */
        Button(
            onClick = onBack
        ) {

            Text(
                text = "← 設定に戻る"
            )
        }
    }
}