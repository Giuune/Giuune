package com.project.giunnae.common.presentation.mypage.student

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.project.giunnae.common.presentation.common.addFocusCleaner
import com.project.giunnae.common.presentation.common.text.GPText
import com.project.giunnae.common.presentation.home.student.StudentHomeComponent
import com.project.giunnae.common.util.GLog
import com.project.giunnae.common.util.gsp

private const val TAG = "StudentMyPageScreen"
@Composable
internal fun StudentMyPageScreen(
    component: StudentMyPageComponent,
    modifier: Modifier = Modifier,
) {
    GLog.d(TAG, "onCreate")

    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .addFocusCleaner(focusManager)
            .fillMaxSize()
            .imePadding(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            GPText(
                modifier = Modifier.align(Alignment.Center),
                text = "StudentMyPageScreen",
                textSize = 20.gsp
            )
        }
    }
}