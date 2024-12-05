package com.project.giunnae.common.presentation.roadmap.student

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
import com.project.giunnae.common.presentation.common.spacer.SpH
import com.project.giunnae.common.presentation.common.text.GPText
import com.project.giunnae.common.presentation.common.text.GPTitleText
import com.project.giunnae.common.presentation.common.textfield.GPTextField
import com.project.giunnae.common.presentation.common.topbar.GPTopBar
import com.project.giunnae.common.presentation.signup.SignupComponent
import com.project.giunnae.common.presentation.signup.content.SignupInputColumn
import com.project.giunnae.common.presentation.signup.intent.InfoStore
import com.project.giunnae.common.ui.theme.GPColor
import com.project.giunnae.common.util.GLog
import com.project.giunnae.common.util.GPFontFamily
import com.project.giunnae.common.util.gdp
import com.project.giunnae.common.util.gsp
import com.project.giunnae.icon_back_arrow
import com.project.giunnae.icon_lock
import com.project.giunnae.icon_person
import com.project.giunnae.image_logo
import org.jetbrains.compose.resources.painterResource

private const val TAG = "StudentRoadmapScreen"
@Composable
internal fun StudentRoadmapScreen(
    component: StudentRoadmapComponent,
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
                text = "StudentRoadmapScreen",
                textSize = 20.gsp
            )
        }
    }
}

