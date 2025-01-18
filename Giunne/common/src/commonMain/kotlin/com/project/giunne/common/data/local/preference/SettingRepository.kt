package com.project.giunne.common.data.local.preference

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SettingsListener

public class SettingRepository(
    private val settings: Settings
) {
//    public val mySettings: List<SettingConfig<*>> = listOf(
//        StringSettingConfig(settings, "MY_STRING", ""),
//        StringSettingConfig(settings, "EMAIL", "")
//    )
    public val idPref: SettingConfig<*> = StringSettingConfig(settings, "ID", "")
    public val passwordPref: SettingConfig<*> = StringSettingConfig(settings, "PASSWORD", "")

    public fun clear(): Unit = settings.clear()
}

public sealed class SettingConfig<T>(
    private val settings: Settings,
    public val key: String,
    private val defaultValue: T
) {
    protected abstract fun getStringValue(settings: Settings, key: String, defaultValue: T): String
    protected abstract fun setStringValue(settings: Settings, key: String, value: String)
    protected abstract fun addListener(
        settings: ObservableSettings,
        key: String,
        defaultValue: T,
        callback: (T) -> Unit
    ): SettingsListener

    private var listener: SettingsListener? = null

    public fun remove(): Unit = settings.remove(key)
    public fun exists(): Boolean = settings.hasKey(key)

    public fun get(): String = getStringValue(settings, key, defaultValue)
    public fun set(value: String): Boolean {
        return try {
            setStringValue(settings, key, value)
            true
        } catch (exception: Exception) {
            false
        }
    }

    public var isLoggingEnabled: Boolean
        get() = listener != null
        set(value) {
            val settings = settings as? ObservableSettings ?: return
            listener = if (value) {
                listener?.deactivate() // just in case
                addListener(settings, key, defaultValue) { println("$key = ${get()}") }
            } else {
                listener?.deactivate()
                null
            }
        }

    override fun toString(): String = key
}

public class StringSettingConfig(settings: Settings, key: String, defaultValue: String) :
    SettingConfig<String>(settings, key, defaultValue) {

    override fun getStringValue(settings: Settings, key: String, defaultValue: String): String =
        settings.getString(key, defaultValue)

    override fun setStringValue(settings: Settings, key: String, value: String): Unit =
        settings.putString(key, value)

    override fun addListener(
        settings: ObservableSettings,
        key: String,
        defaultValue: String,
        callback: (String) -> Unit
    ): SettingsListener =
        settings.addStringListener(key, defaultValue, callback)
}

public class BooleanSettingConfig(settings: Settings, key: String, defaultValue: Boolean) :
        SettingConfig<Boolean>(settings, key, defaultValue) {
    override fun getStringValue(settings: Settings, key: String, defaultValue: Boolean): String =
        settings.getBoolean(key, defaultValue).toString()

    override fun setStringValue(settings: Settings, key: String, value: String): Unit =
        settings.putBoolean(key, value.toBoolean())

    override fun addListener(
        settings: ObservableSettings,
        key: String,
        defaultValue: Boolean,
        callback: (Boolean) -> Unit
    ): SettingsListener =
        settings.addBooleanListener(key, defaultValue, callback)
}