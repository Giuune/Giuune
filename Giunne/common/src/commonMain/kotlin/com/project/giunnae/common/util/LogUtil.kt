package com.project.giunnae.common.util

import io.github.aakira.napier.Napier

internal object GLog {
    fun d(tag: String = "", message: String) {
//        if (Define.IS_DEBUG_MODE) Napier.d(tag = tag) { "$tag :: $message" }
        Napier.d(tag = tag) { "$tag :: $message" }
    }
    fun e(tag: String?, message: String) {
//        if (Define.IS_DEBUG_MODE) Napier.e(tag = tag) { "$tag :: $message" }
        Napier.e(tag = tag) { "$tag :: $message" }
    }
}