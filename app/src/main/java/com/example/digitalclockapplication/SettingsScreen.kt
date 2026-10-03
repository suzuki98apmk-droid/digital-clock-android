package com.example.digitalclockapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SettingsScreen(

    settings: ClockSettings,

    onSettingsChange:
        (ClockSettings) -> Unit,

    onAboutClick: () -> Unit,

    onBack: () -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
            .padding(20.dp)
    ) {

        /*
         * ==================================
         * ヘッダー
         * ==================================
         */

        Row(

            modifier =
                Modifier.fillMaxWidth(),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Button(
                onClick = onBack
            ) {

                Text(
                    text = "←",
                    fontSize = 20.sp
                )
            }


            Spacer(
                modifier =
                    Modifier.weight(1f)
            )


            Text(
                text = "設定",
                fontSize = 28.sp,
                color = Color.White
            )


            Spacer(
                modifier =
                    Modifier.weight(1f)
            )


            Spacer(
                modifier =
                    Modifier.width(50.dp)
            )
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        /*
         * ==================================
         * 時計
         * ==================================
         */

        SettingsSectionTitle(
            text = "時計"
        )


        /*
         * 12 / 24時間
         */
        SettingSwitchRow(

            title = "12時間表示",

            checked =
                settings.is12HourMode,

            onCheckedChange = {

                onSettingsChange(
                    settings.copy(
                        is12HourMode = it
                    )
                )
            }
        )


        /*
         * 秒表示
         */
        SettingSwitchRow(

            title = "秒表示",

            checked =
                settings.showSeconds,

            onCheckedChange = {

                onSettingsChange(
                    settings.copy(
                        showSeconds = it
                    )
                )
            }
        )


        /*
         * 曜日表示
         */
        SettingSwitchRow(

            title = "曜日表示",

            checked =
                settings.showWeekday,

            onCheckedChange = {

                onSettingsChange(
                    settings.copy(
                        showWeekday = it
                    )
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        /*
         * ==================================
         * デザイン
         * ==================================
         */

        SettingsSectionTitle(
            text = "デザイン"
        )


        /*
         * 文字サイズ
         */
        Text(

            text =
                "文字サイズ  ${settings.fontSize.toInt()}sp",

            fontSize = 18.sp,

            color = Color.White
        )


        Slider(

            value =
                settings.fontSize,

            onValueChange = {

                onSettingsChange(
                    settings.copy(
                        fontSize = it
                    )
                )
            },

            valueRange =
                30f..120f,

            steps = 8
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        /*
         * 背景色
         */
        Text(

            text = "背景色",

            fontSize = 18.sp,

            color = Color.White
        )


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        ColorPalette(

            selectedIndex =
                settings.backgroundIndex,

            onColorSelected = {

                onSettingsChange(
                    settings.copy(
                        backgroundIndex = it
                    )
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        /*
         * ==================================
         * 表示
         * ==================================
         */

        SettingsSectionTitle(
            text = "表示"
        )


        /*
         * 全画面
         */
        SettingSwitchRow(

            title = "全画面表示",

            checked =
                settings.fullscreen,

            onCheckedChange = {

                onSettingsChange(
                    settings.copy(
                        fullscreen = it
                    )
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        /*
         * ==================================
         * その他
         * ==================================
         */

        SettingsSectionTitle(
            text = "その他"
        )


        SettingButtonRow(

            title = "アプリについて",

            onClick =
                onAboutClick
        )
    }
}


/*
 * ========================================
 * セクションタイトル
 * ========================================
 */

@Composable
fun SettingsSectionTitle(
    text: String
) {

    Text(

        text = text,

        fontSize = 15.sp,

        color =
            Color(0xFFAAAAAA),

        modifier =
            Modifier.padding(
                bottom = 8.dp
            )
    )
}


/*
 * ========================================
 * Switch設定行
 * ========================================
 */

@Composable
fun SettingSwitchRow(

    title: String,

    checked: Boolean,

    onCheckedChange:
        (Boolean) -> Unit
) {

    Row(

        modifier =
            Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 5.dp
                ),

        horizontalArrangement =
            Arrangement.SpaceBetween,

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(

            text = title,

            fontSize = 18.sp,

            color =
                Color.White
        )


        Switch(

            checked =
                checked,

            onCheckedChange =
                onCheckedChange
        )
    }
}


/*
 * ========================================
 * ボタン設定行
 * ========================================
 */

@Composable
fun SettingButtonRow(

    title: String,

    onClick: () -> Unit
) {

    Row(

        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = onClick
                )
                .padding(
                    vertical = 15.dp
                ),

        horizontalArrangement =
            Arrangement.SpaceBetween,

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(

            text = title,

            fontSize = 18.sp,

            color =
                Color.White
        )


        Text(

            text = ">",

            fontSize = 22.sp,

            color =
                Color(0xFFAAAAAA)
        )
    }
}


/*
 * ========================================
 * カラーパレット
 * ========================================
 */

@Composable
fun ColorPalette(

    selectedIndex: Int,

    onColorSelected:
        (Int) -> Unit
) {

    val colors = listOf(

        Color.Black,

        Color(0xFF101820),

        Color(0xFF202020),

        Color(0xFF0D1B2A),

        Color(0xFF1B1B1B),

        Color.White,

        Color(0xFFF5F5F5)
    )


    LazyRow(

        horizontalArrangement =
            Arrangement.spacedBy(12.dp)
    ) {

        itemsIndexed(colors) { index, color ->

            ColorItem(

                color = color,

                selected =
                    index == selectedIndex,

                onClick = {

                    onColorSelected(index)
                }
            )
        }
    }
}


/*
 * ========================================
 * カラーパレット1個
 * ========================================
 */

@Composable
fun ColorItem(

    color: Color,

    selected: Boolean,

    onClick: () -> Unit
) {

    Box(

        modifier =
            Modifier
                .size(50.dp)
                .background(color)
                .border(
                    width =
                        if (selected)
                            3.dp
                        else
                            1.dp,

                    color =
                        if (selected)
                            Color.White
                        else
                            Color.Gray
                )
                .clickable(
                    onClick = onClick
                )
    )
}