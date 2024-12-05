package com.project.giunnae.common.presentation.common.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.project.giunnae.common.ui.theme.GPColor
import com.project.giunnae.common.util.GPFontFamily
import com.project.giunnae.common.util.gsp

@Composable
fun GPTitleText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 14.gsp,
    textColor: Color = GPColor.TextBlack,
    fontFamily: FontFamily = GPFontFamily.Medium,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontSize = textSize,
        color = textColor,
        textAlign = textAlign,
        maxLines = maxLines
    )
}