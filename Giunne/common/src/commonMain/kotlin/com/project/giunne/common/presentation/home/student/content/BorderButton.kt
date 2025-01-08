package com.project.giunne.common.presentation.home.student.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.giunne.Res
import com.project.giunne.common.presentation.common.text.GPText
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.common.util.GPFontFamily
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp
import org.jetbrains.compose.resources.painterResource

@Composable
fun BorderButton(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(color = GPColor.Transparent)
            .border(BorderStroke(1.gdp, GPColor.MainOrangeColor), RoundedCornerShape(12.gdp))
            .padding(14.gdp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GPText(
            text = "게시판 보러가기",
            textSize = 12.gsp,
            fontFamily = GPFontFamily.Bold,
            textColor = GPColor.MainOrangeColor
        )

        Spacer(modifier = Modifier.width(4.gdp))

        Icon(
            modifier = Modifier.height(12.gdp),
            painter = painterResource(Res.drawable.icon_next),
            contentDescription = "게시판 보러가기",
            tint = GPColor.MainOrangeColor
        )
    }
}