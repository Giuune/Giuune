package com.project.giunnae.android

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.DefaultComponentContext
import com.project.giunnae.common.data.local.preference.SettingRepository
import com.project.giunnae.common.presentation.root.RootComponent
import com.project.giunnae.common.presentation.root.RootContent
import com.project.giunnae.common.ui.theme.GiunnaeTheme
import com.russhwolf.settings.SharedPreferencesSettings

class MainActivity : AppCompatActivity() {
    private val settingsRepository by lazy {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val settings = SharedPreferencesSettings(sharedPrefs)
        SettingRepository(settings)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = RootComponent(
            componentContext = DefaultComponentContext(
                lifecycle = lifecycle,
            ),
        )

        // 앱이 콘텐츠를 그리는 위치를 완전히 제어할 수 있도록 하기 위한 설정
        // 이 호출을 통해 앱이 시스템 UI 뒤에 표시되도록 요청
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.WHITE
        window.navigationBarColor = android.graphics.Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        setContent {
            GiunnaeTheme {
                RootContent(
                    root,
                    modifier = Modifier.systemBarsPadding()
                )
            }
        }
    }
}