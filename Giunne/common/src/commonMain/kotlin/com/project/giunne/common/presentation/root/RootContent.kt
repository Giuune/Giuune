package com.project.giunne.common.presentation.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import coil3.compose.setSingletonImageLoaderFactory
import com.arkivanov.decompose.FaultyDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.isEnter
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.project.giunne.common.presentation.common.newImageLoader
import com.project.giunne.common.presentation.login.LoginScreen
import com.project.giunne.common.presentation.main.splash.SplashScreen
import com.project.giunne.common.presentation.main.student.StudentMainScreen
import com.project.giunne.common.presentation.main.teacher.TeacherMainScreen
import com.project.giunne.common.presentation.signup.SignupScreen
import com.project.giunne.common.util.NanumRound
import kotlinx.coroutines.delay

private const val TAG = "RootContent"
@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    /* settings init */
    NanumRound.initFont()
    setSingletonImageLoaderFactory { context ->
        newImageLoader(context, true)
    }
    //****//

    LaunchedEffect(Unit) {
        delay(1000)
        component.navigateToLogin()
    }

    Scaffold (
        modifier = modifier
    ) {
        Box (
            modifier = modifier
                .fillMaxSize()
        ) {
            Children(component = component)
        }
    }
}

@Composable
private fun Children(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
//        animation = stackAnimation(fade()),
        animation = tabAnimation()
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.SplashChild -> SplashScreen()
            is RootComponent.Child.LoginChild -> LoginScreen(
                component = child.component,
                navigateSignup = { component.navigateToSignup() }
            )
            is RootComponent.Child.SignupChild -> SignupScreen(
                component = child.component,
                onClickBackButton = { component.navigateBack() }
            )
            is RootComponent.Child.StudentMainChild -> StudentMainScreen(component = child.component)
            is RootComponent.Child.TeacherMainChild -> TeacherMainScreen(component = child.component)
        }
    }
}

@OptIn(FaultyDecomposeApi::class)
@Composable
private fun tabAnimation(): StackAnimation<Any, RootComponent.Child> =
    stackAnimation { child, otherChild, direction ->
        val index = child.instance.index
        val otherIndex = otherChild.instance.index
        val anim = slide()
        if ((index > otherIndex) == direction.isEnter) anim else anim.flipSide()
    }

private val RootComponent.Child.index: Int
    get() =
        when (this) {
            is RootComponent.Child.SplashChild -> 0
            is RootComponent.Child.LoginChild -> 1
            is RootComponent.Child.SignupChild -> 2
            is RootComponent.Child.StudentMainChild -> 3
            is RootComponent.Child.TeacherMainChild -> 4
        }

private fun StackAnimator.flipSide(): StackAnimator =
    StackAnimator { direction, isInitial, onFinished, content ->
        invoke(
            direction = direction.flipSide(),
            isInitial = isInitial,
            onFinished = onFinished,
            content = content,
        )
    }

private fun Direction.flipSide(): Direction =
    when (this) {
        Direction.ENTER_FRONT -> Direction.ENTER_BACK
        Direction.EXIT_FRONT -> Direction.EXIT_FRONT
        Direction.ENTER_BACK -> Direction.ENTER_BACK
        Direction.EXIT_BACK -> Direction.EXIT_FRONT
    }