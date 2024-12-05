package com.project.giunnae.common.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput

@Composable
inline fun Modifier.noRippleClickable(
    clickable: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    crossinline onClick: () -> Unit,
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = interactionSource
    ) {
        onClick()
    }.pointerHoverIcon(
        icon = if (clickable) PointerIcon.Hand else PointerIcon.Default
    )
}

fun Modifier.addFocusCleaner(focusManager: FocusManager, doOnClear: () -> Unit = {}): Modifier {
    return this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}

@Composable
inline fun Modifier.noRippleClickableWithoutHover(
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    crossinline onClick: () -> Unit,
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = interactionSource
    ) {
        onClick()
    }
}