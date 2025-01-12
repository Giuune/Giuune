package com.project.giunne.common.presentation.home.teacher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.giunne.common.presentation.common.empty.GPResultEmpty
import com.project.giunne.common.presentation.home.common.TextFieldWithButton
import com.project.giunne.common.util.gdp

@Composable
fun TeacherEmptyHomeScreen(
    modifier: Modifier,
    roadMapTitle: String,
    onValueChange: (String) -> Unit,
    onCreateRoadMapClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GPResultEmpty(
            title = "아직 생성된 로드맵이 없어요",
            highlightRange = 7..9
        )
        Spacer(modifier = Modifier.height(8.gdp))
        TextFieldWithButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.gdp),
            hint = "ex. 00초 1기",
            value = roadMapTitle,
            buttonTitle = "생성하기",
            onValueChange = { onValueChange(it) },
            onButtonClick = onCreateRoadMapClick
        )
    }
}