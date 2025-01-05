package com.project.giunne.common.presentation.common.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.giunne.Res
import com.project.giunne.common.util.gdp
import com.project.giunne.image_giunne
import org.jetbrains.compose.resources.painterResource

@Composable
fun GPTopBarWithImage(
    title: @Composable () -> Unit = {},
    rightIcon: @Composable () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.gdp)
            .padding(horizontal = 16.gdp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.align(Alignment.CenterStart))
        {
            Image(
                modifier = Modifier
                    .size(44.dp),
                painter = painterResource(Res.drawable.image_giunne),
                contentDescription = null
            )
        }

        title()

        Box(modifier = Modifier.align(Alignment.CenterEnd)){
            rightIcon()
        }
    }
}