package com.project.giunne.common.presentation.main.teacher

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.giunne.common.presentation.home.teacher.TeacherEmptyHomeScreen

@Composable
fun TeacherMainScreen(
    modifier: Modifier = Modifier,
    component: TeacherMainComponent
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        /* TODO("Default 화면 나중에 API 통신 후 구현") */
        TeacherEmptyHomeScreen(
            modifier = Modifier.fillMaxSize(),
            roadMapTitle = "",
            onValueChange = {},
            onCreateRoadMapClick = {}
        )
    }
}