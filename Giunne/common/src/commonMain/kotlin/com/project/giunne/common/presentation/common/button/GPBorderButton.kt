package com.project.giunne.common.presentation.common.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.project.giunne.common.presentation.common.noRippleClickable
import com.project.giunne.common.presentation.common.text.GPText
import com.project.giunne.common.util.GPFontFamily
import com.project.giunne.common.util.gdp
import com.project.giunne.common.util.gsp

@Composable
internal fun GPBorderButton(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    normalColor: Color,
    pressColor: Color,
    borderColor: Color,
    onClick: () -> Unit,
    text: String = "",
    shape: Shape = RoundedCornerShape(40.gdp),
    textSize: TextUnit = 20.gsp
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()

    val buttonFillColor by animateColorAsState(
        targetValue = if (isHovered) borderColor else normalColor
    )

    val buttonTextColor by animateColorAsState(
        targetValue = if (isHovered) normalColor else borderColor
    )

    Row(
        modifier = modifier
            .shadow(
                elevation = if(isPressed) 0.gdp else 3.gdp,
                shape = shape,
            )
            .border(
                width = 1.gdp,
                color = when {
                    isPressed -> pressColor
                    else -> borderColor
                },
                shape = shape
            )
            .background(
                color = when {
                    isPressed -> pressColor
                    else -> buttonFillColor
                },
                shape = shape
            )
            .pointerHoverIcon(icon = PointerIcon.Hand)
            .noRippleClickable(
                interactionSource = interactionSource
            ) { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        GPText(
            text = text,
            textColor = buttonTextColor,
            fontFamily = GPFontFamily.Bold,
            textAlign = TextAlign.Center,
            textSize = textSize,
        )
    }
}