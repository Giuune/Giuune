package com.project.giunne.common.util

import android.content.Context
import android.preference.PreferenceManager
import com.project.giunne.common.data.local.preference.SettingRepository
import com.russhwolf.settings.SharedPreferencesSettings

public actual object PreferencesUtil {
    public actual var settingsRepository: SettingRepository? = null

    public fun init(context: Context) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val settings = SharedPreferencesSettings(sharedPrefs)
        settingsRepository = SettingRepository(settings)
    }
}