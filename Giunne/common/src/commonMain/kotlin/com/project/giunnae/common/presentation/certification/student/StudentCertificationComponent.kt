package com.project.giunnae.common.presentation.certification.student

import com.arkivanov.decompose.ComponentContext
import com.project.giunnae.common.util.GLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent

private const val TAG = "StudentCertificationComponent"
class StudentCertificationComponent(
    componentContext: ComponentContext,
): KoinComponent, ComponentContext by componentContext {
    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        GLog.d(TAG, "onCreate")
    }
}