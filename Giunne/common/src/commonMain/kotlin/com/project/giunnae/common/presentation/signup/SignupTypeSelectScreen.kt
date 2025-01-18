package com.project.giunnae.common.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.arkivanov.essenty.backhandler.BackHandler
import com.project.giunnae.Res
import com.project.giunnae.common.presentation.common.addFocusCleaner
import com.project.giunnae.common.presentation.common.button.GPButton
import com.project.giunnae.common.presentation.common.noRippleClickable
import com.project.giunnae.common.presentation.common.noRippleClickableWithoutHover
import com.project.giunnae.common.presentation.common.spacer.SpH
import com.project.giunnae.common.presentation.common.text.GPText
import com.project.giunnae.common.presentation.common.text.GPTitleText
import com.project.giunnae.common.presentation.common.textfield.GPTextField
import com.project.giunnae.common.presentation.common.topbar.GPTopBar
import com.project.giunnae.common.presentation.signup.SignupComponent.Companion.TYPE_STUDENT
import com.project.giunnae.common.presentation.signup.SignupComponent.Companion.TYPE_TEACHER
import com.project.giunnae.common.presentation.signup.content.SignupInputColumn
import com.project.giunnae.common.presentation.signup.content.SignupTypeSelectButton
import com.project.giunnae.common.presentation.signup.intent.InfoStore
import com.project.giunnae.common.ui.theme.GPColor
import com.project.giunnae.common.util.GLog
import com.project.giunnae.common.util.GPFontFamily
import com.project.giunnae.common.util.gdp
import com.project.giunnae.common.util.gsp
import com.project.giunnae.icon_arrow_right
import com.project.giunnae.icon_back_arrow
import com.project.giunnae.icon_lock
import com.project.giunnae.icon_person
import com.project.giunnae.image_logo
import com.project.giunnae.image_student_type
import com.project.giunnae.image_teacher_type
import org.jetbrains.compose.resources.painterResource

private const val TAG = "SignupTypeSelectScreen"
@Composable
internal fun SignupTypeSelectScreen(
    onClickBackButton: () -> Unit,
    onSelected: (type: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    GLog.d(TAG, "onCreate")

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(GPColor.BackgroundLightGray)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GPTopBar(
                    titleText = "회원가입",
                    onBackButtonClicked = onClickBackButton
                )
                Column(
                    modifier = modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .background(GPColor.BackgroundLightGray)
                        .padding(bottom = 16.gdp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(52.gdp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        GPTitleText(
                            modifier = Modifier.align(Alignment.Center),
                            text = "계정 유형을 선택해주세요! ✅",
                            textSize = 14.gsp,
                            textColor = GPColor.TextBlack,
                            fontFamily = GPFontFamily.Medium
                        )
                    }
                    SignupTypeSelectButton(
                        modifier = Modifier
                            .padding(horizontal = 16.gdp)
                            .fillMaxWidth()
                            .height(64.gdp),
                        image = painterResource(Res.drawable.image_student_type),
                        text = "학생용 계정 만들기",
                        onClick = { onSelected(TYPE_STUDENT) },
                    )
                    SpH(20.gdp)
                    SignupTypeSelectButton(
                        modifier = Modifier
                            .padding(horizontal = 16.gdp)
                            .fillMaxWidth()
                            .height(64.gdp),
                        image = painterResource(Res.drawable.image_teacher_type),
                        text = "선생님용 계정 만들기",
                        onClick = { onSelected(TYPE_TEACHER) },
                    )
                }
            }
        }
    }
}

