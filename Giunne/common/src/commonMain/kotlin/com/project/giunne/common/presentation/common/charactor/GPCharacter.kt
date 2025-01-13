package com.project.giunne.common.presentation.common.charactor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import com.project.giunne.Res
import com.project.giunne.common.util.gdp
import com.project.giunne.test_character
import com.project.giunne.test_item
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/* TODO("나중에 API 나오구 Spec에 맞게 변경") */
data class TestItem(
    val size: IntSize,
    val offsetX: Int,
    val offsetY: Int,
    val image: DrawableResource
)

@Composable
fun GPCharacter(
    modifier: Modifier = Modifier,
    character: DrawableResource = Res.drawable.test_character,
    items: List<TestItem> = listOf(TestItem(size = IntSize(166, 157), offsetX = 45, offsetY = 12, image = Res.drawable.test_item))
) {
    Box {
        Image(
            modifier = modifier,
            painter = painterResource(character),
            contentDescription = null
        )
        items.forEach { item ->
            Image(
                modifier = Modifier
                    .size(
                        width = item.size.width.gdp,
                        height = item.size.height.gdp
                    )
                    .offset(
                        x = item.offsetX.gdp,
                        y = item.offsetY.gdp
                    ),
                painter = painterResource(item.image),
                contentDescription = ""
            )
        }
    }
}