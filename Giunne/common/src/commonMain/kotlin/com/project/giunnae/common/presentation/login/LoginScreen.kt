package com.project.giunnae.common.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.project.giunnae.Res
import com.project.giunnae.common.presentation.common.addFocusCleaner
import com.project.giunnae.common.presentation.common.button.GPButton
import com.project.giunnae.common.presentation.common.noRippleClickable
import com.project.giunnae.common.presentation.common.text.GPText
import com.project.giunnae.common.presentation.common.textfield.GPTextField
import com.project.giunnae.common.ui.theme.GPColor
import com.project.giunnae.common.util.GLog
import com.project.giunnae.common.util.GPFontFamily
import com.project.giunnae.common.util.gdp
import com.project.giunnae.common.util.gsp
import com.project.giunnae.icon_lock
import com.project.giunnae.icon_person
import com.project.giunnae.image_logo
import org.jetbrains.compose.resources.painterResource

private const val TAG = "LoginScreen"
@Composable
internal fun LoginScreen(
    component: LoginComponent,
    navigateSignup: () -> Unit,
    modifier: Modifier = Modifier,
) {
    GLog.d(TAG, "onCreate")

    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier
            .addFocusCleaner(focusManager)
            .fillMaxSize()
            .imePadding(),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(GPColor.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image( // 로고 이미지
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 16.gdp),
                painter = painterResource(Res.drawable.image_logo),
                contentDescription = "Giunnae Logo"
            )
            Spacer(modifier = Modifier.height(60.gdp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GPTextField(
                    modifier = Modifier
                        .padding(horizontal = 16.gdp)
                        .fillMaxWidth()
                        .height(60.gdp)
                        .background(color = GPColor.BackgroundLightGray)
                        .shadow(3.gdp, RoundedCornerShape(20.gdp)),
                    shape = RoundedCornerShape(20.gdp),
                    textStyle = TextStyle(
                        color = GPColor.TextBlack,
                        fontSize = 12.gsp,
                        fontFamily = GPFontFamily.Medium
                    ),
                    value = component.id,
                    onValueChange = { component.id = it },
                    border = true,
                    placeholder = {
                        GPText(
                            text = "아이디",
                            textSize = 12.gsp,
                            fontFamily = GPFontFamily.Medium,
                            textColor = GPColor.ButtonGray
                        )
                    },
                    prefix = {
                        Image(
                            modifier = Modifier.size(16.gdp),
                            painter = painterResource(Res.drawable.icon_person),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(color = GPColor.ButtonGray)
                        )
                    },
                )
                Spacer(modifier = Modifier.size(20.gdp))
                GPTextField(
                    modifier = Modifier
                        .padding(horizontal = 16.gdp)
                        .fillMaxWidth()
                        .height(60.gdp)
                        .background(color = GPColor.BackgroundLightGray)
                        .shadow(3.gdp, RoundedCornerShape(20.gdp)),
                    shape = RoundedCornerShape(20.gdp),
                    textStyle = TextStyle(
                        color = GPColor.TextBlack,
                        fontSize = 12.gsp,
                        fontFamily = GPFontFamily.Medium
                    ),
                    value = component.pass,
                    onValueChange = { component.pass = it },
                    border = true,
                    visualTransformation = PasswordVisualTransformation(),
                    placeholder = {
                        GPText(
                            text = "비밀번호",
                            textSize = 12.gsp,
                            fontFamily = GPFontFamily.Medium,
                            textColor = GPColor.ButtonGray
                        )
                    },
                    prefix = {
                        Image(
                            modifier = Modifier.size(16.gdp),
                            painter = painterResource(Res.drawable.icon_lock),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(color = GPColor.ButtonGray),
                            contentScale = ContentScale.FillHeight
                        )
                    },
                )
                Spacer(Modifier.height(20.gdp))
                GPButton(
                    modifier = Modifier
                        .padding(horizontal = 16.gdp)
                        .fillMaxWidth()
                        .height(40.gdp),
                    normalColor = GPColor.ButtonBlack,
                    pressColor = GPColor.ButtonPressBlack,
                    hoverColor = GPColor.ButtonHoverBlack,
                    onClick = {
                        component.onLoginButtonClick()
                    },
                ) {
                    GPText(
                        text = "Login",
                        textSize = 14.gsp,
                        fontFamily = GPFontFamily.Bold,
                        textColor = GPColor.White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.gdp)
                        .height(30.gdp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GPText(
                        modifier = Modifier
                            .noRippleClickable { navigateSignup() },
                        text = "아직 회원이 아니신가요?",
                        textSize = 12.gsp,
                        textColor = GPColor.ButtonGray,
                        fontFamily = GPFontFamily.Bold
                    )
                    GPText(
                        modifier = Modifier
                            .noRippleClickable {  },
                        text = "아이디 / 비밀번호 찾기",
                        textSize = 12.gsp,
                        textColor = GPColor.ButtonGray,
                        fontFamily = GPFontFamily.Bold
                    )
                }
            }
        }
    }
}

