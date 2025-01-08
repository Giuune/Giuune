package com.project.giunne.common.presentation.home.student.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.project.giunne.Res
import com.project.giunne.common.presentation.common.shape.GPSquircleShape
import com.project.giunne.common.presentation.common.text.GPAnnotatedText
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp
import com.project.giunne.icon_student_check
import com.project.giunne.icon_student_progress
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentRoadMapLevelBox(
    modifier: Modifier,
    roadMapLevel: String
) {
    RowWithDropShadow(
        modifier = modifier
            .padding(16.gdp)
    ) {
        GPSquircleShape(
            modifier = Modifier
                .size(56.gdp),
            backgroundColor = GPColor.BackgroundLightGray
        ) {
            Icon(
                modifier = Modifier.size((56 / 3).gdp),
                tint = GPColor.MainOrangeColor,
                painter = painterResource(Res.drawable.icon_student_progress),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.gdp))

            GPAnnotatedText(
                text = buildAnnotatedString {
                    append("현재 나는 ")
                    withStyle(
                        style = SpanStyle(
                            color = GPColor.MainOrangeColor,
                            fontSize = 18.gsp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("${roadMapLevel}단계 ")
                    }
                    append("진행중이에요!")
                },
            )
        }
    }
}