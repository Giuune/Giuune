package com.project.giunnae.android

import android.app.Application
import com.project.giunnae.common.di.sharedModule
import com.project.giunnae.common.util.DpUtil
import com.project.giunnae.common.util.PreferencesUtil
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