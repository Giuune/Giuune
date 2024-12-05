package com.project.giunnae.common.util

import com.project.giunnae.common.data.local.preference.SettingRepository

expect object PreferencesUtil {
    var settingsRepository: SettingRepository?
}