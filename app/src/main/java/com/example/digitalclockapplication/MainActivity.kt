package com.example.digitalclockapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            DigitalClockApp()
        }
    }
}


@Composable
fun DigitalClockApp() {

    /*
     * 現在の画面
     *
     * 0 = 時計
     * 1 = 設定
     * 2 = アプリについて
     */
    var currentScreen by remember {
        mutableStateOf(0)
    }


    /*
     * アプリ設定
     */
    var settings by remember {

        mutableStateOf(
            ClockSettings()
        )
    }


    when (currentScreen) {

        /*
         * ============================
         * 時計画面
         * ============================
         */
        0 -> {

            ClockScreen(

                settings = settings,

                onSettingsClick = {

                    currentScreen = 1
                }
            )
        }


        /*
         * ============================
         * 設定画面
         * ============================
         */
        1 -> {

            SettingsScreen(

                settings = settings,

                onSettingsChange = {

                    settings = it
                },

                onAboutClick = {

                    currentScreen = 2
                },

                onBack = {

                    currentScreen = 0
                }
            )
        }


        /*
         * ============================
         * アプリについて
         * ============================
         */
        2 -> {

            AboutScreen(

                onBack = {

                    currentScreen = 1
                }
            )
        }
    }
}