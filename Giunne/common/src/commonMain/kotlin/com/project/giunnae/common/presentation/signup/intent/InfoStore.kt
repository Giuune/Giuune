package com.project.giunnae.common.presentation.signup.intent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.giunnae.common.presentation.signup.state.InfoState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

class InfoStore(
    val scope: CoroutineScope
) {
    val infoState = mutableStateOf(InfoState())

    fun onIdTextChanged(
        text: String
    ) {
        setState {
            copy(idText = text)
        }
    }

    fun onPassTextChanged(
        text: String
    ) {
        setState {
            copy(passText = text)
        }
    }

    fun onPassConfTextChanged(
        text: String
    ) {
        setState {
            copy(passConfText = text)
        }
    }

    fun onCodeTextChanged(
        text: String
    ) {
        setState {
            copy(codeText = text)
        }
    }

    private inline fun setState(crossinline block: InfoState.() -> InfoState) {
        infoState.value = block.invoke(infoState.value)
    }
}