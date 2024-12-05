package com.project.giunnae.common.presentation.common.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.giunnae.Res
import com.project.giunnae.common.presentation.common.noRippleClickable
import com.project.giunnae.common.presentation.common.text.GPTitleText
import com.project.giunnae.common.ui.theme.GPColor
import com.project.giunnae.common.util.GPFontFamily
import com.project.giunnae.common.util.gdp
import com.project.giunnae.common.util.gsp
import com.project.giunnae.icon_back_arrow
import com.project.giunnae.icon_logo_mini
import org.jetbrains.compose.resources.painterResource

@Composable
fun GPMainTopBar(
    modifier: Modifier = Modifier,
    titleText: String? = null
) {
    Box(
        modifier = Modifier
            .height(52.gdp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(52.gdp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.height(18.gdp),
                painter = painterResource(Res.drawable.icon_logo_mini),
                contentDescription = null,
            )
        }
        if (titleText != null) {
            GPTitleText(
                modifier = Modifier.align(Alignment.Center),
                text = titleText,
                textSize = 18.gsp,
                textColor = GPColor.TextBlack,
                fontFamily = GPFontFamily.Bold
            )
        }
    }
}