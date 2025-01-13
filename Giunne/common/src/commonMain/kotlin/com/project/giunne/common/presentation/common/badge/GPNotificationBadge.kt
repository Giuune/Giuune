package com.project.giunne.common.presentation.common.badge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.giunne.Res
import com.project.giunne.common.ui.theme.GPColor
import com.project.giunne.icon_badge
import org.jetbrains.compose.resources.painterResource

@Composable
fun GPNotificationBadge(
    modifier: Modifier = Modifier,
    count: Int = 0
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        BadgedBox(
            badge = {
                if (0 < count) {
                    Badge(
                        modifier = Modifier.offset(x = (-4).dp,y = (-4).dp),
                        containerColor = GPColor.MainOrangeColor,
                        contentColor = Color.White
                    ) {
                        val formatCount = if (100 <= count) { "99.." } else count
                        Text(text = "$formatCount")
                    }
                }
            }
        ) {
            Icon(
                painter = painterResource(Res.drawable.icon_badge),
                contentDescription = "notification"
            )
        }
    }
}