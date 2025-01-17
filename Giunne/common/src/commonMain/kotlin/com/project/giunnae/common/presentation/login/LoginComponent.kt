package com.project.giunnae.common.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.project.giunnae.common.data.local.preference.SettingRepository
import com.project.giunnae.common.util.studentID
import com.project.giunnae.common.util.studentPass
import com.project.giunnae.common.util.teacherID
import com.project.giunnae.common.util.teacherPass
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

    internal fun onLoginButtonClick() {
        println("$studentID || $studentPass")
        saveLoginInfo()
        if (id == studentID && pass == studentPass) goToStudentMain()
        if (id == teacherID && pass == teacherPass) goToTeacherMain()
    }

    private fun getLoginInfo() {
        id = prefRepository.idPref.get()
        pass = prefRepository.passwordPref.get()
    }

    private fun saveLoginInfo() {
        prefRepository.idPref.set(id)
        prefRepository.passwordPref.set(pass)
    }

    init {
        Napier.d(tag = TAG) { "onCreate" }
        getLoginInfo()
    }
}