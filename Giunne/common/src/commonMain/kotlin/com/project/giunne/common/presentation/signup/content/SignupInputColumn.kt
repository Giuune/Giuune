package com.project.giunne.common.presentation.signup.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.project.giunne.common.presentation.common.button.GPButton
import com.project.giunne.common.presentation.common.spacer.SpH
import com.project.giunne.common.presentation.common.text.GPText
import com.project.giunne.common.presentation.common.textfield.GPTextField
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.common.util.GPFontFamily
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp

@Composable
fun SignupInputColumn(
    modifier: Modifier = Modifier,
    onConfirmButtonClicked: (() -> Unit)? = null,
    titleText: String,
    inputHintText: String = "",
    text: String,
    onTextChanged: (String) -> Unit,
    focusManager: FocusManager,
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 16.gdp)
    ) {
        Row(
            modifier = Modifier
                .height(40.gdp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GPText(
                text = titleText,
                textSize = 13.gsp,
                textColor = GPColor.TextBlack,
                fontFamily = GPFontFamily.Medium
            )
            if (onConfirmButtonClicked != null) {
                GPButton(
                    modifier = Modifier
                        .width(100.gdp)
                        .height(32.gdp),
                    shape = RoundedCornerShape(12.gdp),
                    normalColor = GPColor.ButtonBlack,
                    pressColor = GPColor.ButtonPressBlack,
                    hoverColor = GPColor.ButtonHoverBlack,
                    onClick = { onConfirmButtonClicked() },
                ) {
                    GPText(
                        text = "중복확인",
                        textSize = 14.gsp,
                        fontFamily = GPFontFamily.Bold,
                        textColor = GPColor.White
                    )
                }
            } else if (inputHintText.isNotEmpty()) {
                GPText(
                    text = inputHintText,
                    textSize = 11.gsp,
                    fontFamily = GPFontFamily.Medium,
                    textColor = GPColor.ButtonGray
                )
            }
        }
        SpH(4.gdp)
        GPTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.gdp)
                .background(color = GPColor.BackgroundLightGray)
                .shadow(2.gdp, RoundedCornerShape(12.gdp)),
            shape = RoundedCornerShape(12.gdp),
            textStyle = TextStyle(
                color = GPColor.TextBlack,
                fontSize = 12.gsp,
                fontFamily = GPFontFamily.Medium
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = if (titleText != "코드 입력") ImeAction.Next else ImeAction.Done
            ),
            visualTransformation = if (titleText == "비밀번호" || titleText == "비밀번호 확인")
                PasswordVisualTransformation()
            else VisualTransformation.None,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) },
                onDone = { focusManager.clearFocus() }
            ),
            value = text,
            onValueChange = { onTextChanged(it) },
            border = true,
        )
    }
}