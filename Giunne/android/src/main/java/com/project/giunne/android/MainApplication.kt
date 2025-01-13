package com.project.giunne.android

import android.app.Application
import com.project.giunne.common.di.sharedModule
import com.project.giunne.common.util.DpUtil
import com.project.giunne.common.util.PreferencesUtil
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesUtil.init(applicationContext)
        DpUtil.initDesplayMetrics(applicationContext)
        startKoin {
            androidContext(this@MainApplication)
            modules(sharedModule)
        }
        Napier.base(DebugAntilog())
    }
}