package com.project.giunne.common.presentation.home.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalFocusManager
import com.project.giunne.Res
import com.project.giunne.common.presentation.common.addFocusCleaner
import com.project.giunne.common.presentation.common.text.GPText
import com.project.giunne.common.presentation.home.student.content.HomeTableItem
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.common.util.GLog
import com.project.giunne.common.util.GPFontFamily
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp
import com.project.giunne.image_test_character
import org.jetbrains.compose.resources.painterResource

private const val TAG = "StudentRoadmapScreen"
@Composable
internal fun StudentHomeScreen(
    component: StudentHomeComponent,
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
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.gdp)
                        .fillMaxWidth()
                        .height(170.gdp)
                ) {
                    HomeTableItem(
                        modifier = Modifier
                            .padding(5.gdp)
                            .shadow(3.gdp, RoundedCornerShape(16.gdp))
                            .background(
                                color = GPColor.White,
                                shape = RoundedCornerShape(16.gdp)
                            )
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.gdp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier.size(100.gdp),
                                painter = painterResource(Res.drawable.image_test_character),
                                contentDescription = null
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                GPText(
                                    text = "Lv. 7",
                                    textSize = 10.gsp,
                                    fontFamily = GPFontFamily.Bold
                                )
                                LinearProgressIndicator(
                                    progress = { 0.74f },
                                    modifier = Modifier
                                        .height(10.gdp)
                                        .fillMaxWidth(),
                                    color = GPColor.MainOrangeColor,
                                    trackColor = GPColor.ButtonGray,
                                    gapSize = 0.gdp,
                                )
                            }
                        }
                    }
                    HomeTableItem(
                        modifier = Modifier
                            .padding(5.gdp)
                            .shadow(3.gdp, RoundedCornerShape(16.gdp))
                            .background(
                                color = GPColor.MainOrangeColor,
                                shape = RoundedCornerShape(16.gdp)
                            )
                            .weight(1f)
                            .fillMaxHeight()
                    ) {

                    }
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.gdp)
                        .fillMaxWidth()
                        .height(160.gdp)
                ) {
                    HomeTableItem(
                        modifier = Modifier
                            .padding(5.gdp)
                            .shadow(3.gdp, RoundedCornerShape(16.gdp))
                            .background(
                                color = GPColor.MainOrangeColor,
                                shape = RoundedCornerShape(16.gdp)
                            )
                            .weight(1f)
                            .fillMaxHeight()
                    ) {

                    }
                    HomeTableItem(
                        modifier = Modifier
                            .padding(5.gdp)
                            .shadow(3.gdp, RoundedCornerShape(16.gdp))
                            .background(
                                color = GPColor.MainOrangeColor,
                                shape = RoundedCornerShape(16.gdp)
                            )
                            .weight(1f)
                            .fillMaxHeight()
                    ) {

                    }
                }
            }
        }
    }
}