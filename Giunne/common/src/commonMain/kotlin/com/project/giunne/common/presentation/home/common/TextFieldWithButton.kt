package com.project.giunne.common.presentation.home.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.project.giunne.common.presentation.common.button.GPButton
import com.project.giunne.common.presentation.common.text.GPText
import com.project.giunne.common.presentation.common.textfield.GPTextField
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.common.util.GPFontFamily
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp

@Composable
fun TextFieldWithButton(
    modifier: Modifier,
    hint: String,
    value: String,
    buttonTitle: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.gdp)
    ) {
        GPTextField(
            modifier = Modifier
                .weight(1f)
                .height(48.gdp)
                .background(color = GPColor.White),
            shape = RoundedCornerShape(10.gdp),
            textStyle = TextStyle(
                color = GPColor.TextBlack,
                fontSize = 12.gsp,
                fontFamily = GPFontFamily.Medium
            ),
            value = value,
            onValueChange = { onValueChange(it) },
            border = true,
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                GPText(
                    text = hint,
                    textSize = 12.gsp,
                    fontFamily = GPFontFamily.Medium,
                    textColor = GPColor.TextLightGray
                )
            }
        )
        GPButton(
            modifier = Modifier
                .height(48.gdp),
            normalColor = GPColor.ButtonOrange,
            pressColor = GPColor.ButtonPressOrange,
            hoverColor = GPColor.ButtonHoverOrange,
            onClick = onButtonClick,
        ) {
            GPText(
                text = buttonTitle,
                textSize = 14.gsp,
                fontFamily = GPFontFamily.Bold,
                textColor = GPColor.White
            )
        }
    }
}