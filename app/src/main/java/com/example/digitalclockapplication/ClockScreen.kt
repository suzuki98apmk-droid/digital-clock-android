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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun ClockScreen(
    settings: ClockSettings,
    onSettingsClick: () -> Unit
) {

    /*
     * 現在時刻
     */
    var currentTime by remember {
        mutableStateOf(LocalDateTime.now())
    }


    /*
     * 1秒ごとに時刻を更新
     */
    LaunchedEffect(Unit) {

        while (true) {

            currentTime = LocalDateTime.now()

            delay(1000)
        }
    }


    /*
     * 時刻フォーマット
     */
    val timePattern = when {

        settings.is12HourMode &&
                settings.showSeconds ->
            "h:mm:ss a"

        settings.is12HourMode &&
                !settings.showSeconds ->
            "h:mm a"

        !settings.is12HourMode &&
                settings.showSeconds ->
            "HH:mm:ss"

        else ->
            "HH:mm"
    }


    val timeFormatter =
        DateTimeFormatter.ofPattern(timePattern)


    /*
     * 日付
     */
    val dateFormatter =
        DateTimeFormatter.ofPattern("yyyy/MM/dd")


    /*
     * 曜日
     */
    val weekday =
        currentTime.dayOfWeek.getDisplayName(
            TextStyle.FULL,
            Locale.ENGLISH
        )


    /*
     * 背景色
     */
    val backgroundColors = listOf(

        Color.Black,

        Color(0xFF101820),

        Color(0xFF202020),

        Color(0xFF0D1B2A),

        Color(0xFF1B1B1B),

        Color.White,

        Color(0xFFF5F5F5)
    )


    val backgroundColor =
        backgroundColors[
            settings.backgroundIndex %
                    backgroundColors.size
        ]


    /*
     * 背景に合わせて文字色変更
     */
    val textColor = when (
        settings.backgroundIndex
    ) {

        5, 6 -> Color.Black

        else -> Color.White
    }


    /*
     * 時計画面
     */
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {


        /*
         * 時刻
         */
        Text(

            text =
                currentTime.format(
                    timeFormatter
                ),

            fontSize =
                settings.fontSize.sp,

            color =
                textColor
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        /*
         * 日付
         */
        Text(

            text =
                currentTime.format(
                    dateFormatter
                ),

            fontSize =
                20.sp,

            color =
                textColor
        )


        /*
         * 曜日
         */
        if (settings.showWeekday) {

            Text(

                text =
                    weekday,

                fontSize =
                    18.sp,

                color =
                    textColor
            )
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        /*
         * 設定ボタン
         */
        Button(

            onClick =
                onSettingsClick
        ) {

            Text(
                text = "⚙ 設定",
                fontSize = 18.sp
            )
        }
    }
}