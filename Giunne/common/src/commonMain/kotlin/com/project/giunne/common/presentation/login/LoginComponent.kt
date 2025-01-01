package com.project.giunne.common.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.project.giunne.common.data.local.preference.SettingRepository
import com.project.giunne.common.util.studentID
import com.project.giunne.common.util.studentPass
import com.project.giunne.common.util.teacherID
import com.project.giunne.common.util.teacherPass
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

private const val TAG = "LoginComponent"
class LoginComponent(
    componentContext: ComponentContext,
    private val prefRepository: SettingRepository,
    val goToStudentMain: () -> Unit,
    val goToTeacherMain: () -> Unit,
): KoinComponent, ComponentContext by componentContext {
    private val scope = CoroutineScope(Dispatchers.IO)

    var id by mutableStateOf(prefRepository.idPref.get())
    var pass by mutableStateOf(prefRepository.passwordPref.get())

    private val _loginFailEffect = Channel<String>()
    val loginFailEffect = _loginFailEffect.receiveAsFlow()

    internal fun onLoginButtonClick() {
        println("$studentID || $studentPass")
        saveLoginInfo()
        if (id == studentID && pass == studentPass) goToStudentMain()
        else if (id == teacherID && pass == teacherPass) goToTeacherMain()
        else {
            scope.launch {
                _loginFailEffect.send(LOGIN_FAIL)
            }
        }
    }

    private fun getLoginInfo() {
        id = prefRepository.idPref.get()
        pass = prefRepository.passwordPref.get()
    }

    private fun saveLoginInfo() {
        prefRepository.idPref.set(id)
        prefRepository.passwordPref.set(pass)
    }

    fun dismissDialog() {
        scope.launch {
            _loginFailEffect.send(NON_FAIL)
        }
    }

    init {
        Napier.d(tag = TAG) { "onCreate" }
        getLoginInfo()
    }

    companion object {
        const val NON_FAIL = ""
        const val LOGIN_FAIL = "login_fail"
    }
}