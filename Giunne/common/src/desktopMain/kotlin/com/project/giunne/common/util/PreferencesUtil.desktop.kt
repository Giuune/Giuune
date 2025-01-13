package com.project.giunne.common.util

import com.project.giunne.common.data.local.preference.SettingRepository
import com.russhwolf.settings.PreferencesSettings
import java.util.prefs.Preferences

public actual object PreferencesUtil {
    public actual var settingsRepository: SettingRepository? = null

    public fun init() {
        val preferences = Preferences.userRoot()
        val settings = PreferencesSettings(preferences)
        settingsRepository = SettingRepository(settings)
    }
}