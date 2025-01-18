package com.project.giunne.common.util

import com.project.giunne.common.data.local.preference.SettingRepository

expect object PreferencesUtil {
    var settingsRepository: SettingRepository?
}