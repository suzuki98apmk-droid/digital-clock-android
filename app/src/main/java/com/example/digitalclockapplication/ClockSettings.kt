package com.example.digitalclockapplication

data class ClockSettings(

    // 秒を表示する
    val showSeconds: Boolean = true,

    // 曜日を表示する
    val showWeekday: Boolean = true,

    // 12時間表示
    // false = 24時間
    // true = 12時間
    val is12HourMode: Boolean = false,

    // 時計の文字サイズ
    val fontSize: Float = 60f,

    // 背景色
    val backgroundIndex: Int = 0,

    // 全画面表示
    val fullscreen: Boolean = false
)