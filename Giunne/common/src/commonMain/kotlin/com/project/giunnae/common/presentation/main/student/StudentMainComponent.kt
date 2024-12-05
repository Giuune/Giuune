package com.project.giunnae.common.presentation.main.student

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.project.giunnae.common.presentation.certification.student.StudentCertificationComponent
import com.project.giunnae.common.presentation.friend.student.StudentFriendComponent
import com.project.giunnae.common.presentation.home.student.StudentHomeComponent
import com.project.giunnae.common.presentation.login.LoginComponent
import com.project.giunnae.common.presentation.main.teacher.TeacherMainComponent
import com.project.giunnae.common.presentation.mypage.student.StudentMyPageComponent
import com.project.giunnae.common.presentation.roadmap.student.StudentRoadmapComponent
import com.project.giunnae.common.presentation.signup.SignupComponent
import com.project.giunnae.common.util.PreferencesUtil
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

class StudentMainComponent(
    componentContext: ComponentContext
): KoinComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<StudentMainConfig>()

    private val stack =
        childStack(
            source = navigation,
            serializer = StudentMainConfig.serializer(),
            initialStack = { listOf(StudentMainConfig.Home) },
            childFactory = ::child,
        )

    val childStack: Value<ChildStack<*, StudentChild>> = stack

    sealed class StudentChild {
        class StudentHomeChild(val component: StudentHomeComponent): StudentChild()
        class StudentRoadmapChild(val component: StudentRoadmapComponent) : StudentChild()
        class StudentCertificationChild(val component: StudentCertificationComponent) : StudentChild()
        class StudentFriendsChild(val component: StudentFriendComponent) : StudentChild()
        class StudentMyPageChild(val component: StudentMyPageComponent) : StudentChild()
    }

    private fun child(config: StudentMainConfig, componentContext: ComponentContext): StudentChild =
        when (config) {
            is StudentMainConfig.Home -> StudentChild.StudentHomeChild(StudentHomeComponent(componentContext))
            is StudentMainConfig.Roadmap -> StudentChild.StudentRoadmapChild(StudentRoadmapComponent(componentContext))
            is StudentMainConfig.Certification -> StudentChild.StudentCertificationChild(StudentCertificationComponent(componentContext))
            is StudentMainConfig.Friends -> StudentChild.StudentFriendsChild(StudentFriendComponent(componentContext))
            is StudentMainConfig.MyPage -> StudentChild.StudentMyPageChild(StudentMyPageComponent(componentContext))
        }

    @Serializable
    sealed interface StudentMainConfig {
        @Serializable
        data object Home : StudentMainConfig

        @Serializable
        data object Roadmap : StudentMainConfig

        @Serializable
        data object Certification : StudentMainConfig

        @Serializable
        data object Friends : StudentMainConfig

        @Serializable
        data object MyPage : StudentMainConfig
    }

    fun navigateToHome() {
        navigation.replaceCurrent(StudentMainConfig.Home)
    }

    fun navigateToRoadmap() {
        navigation.replaceCurrent(StudentMainConfig.Roadmap)
    }

    fun navigateToCertification() {
        navigation.replaceCurrent(StudentMainConfig.Certification)
    }

    fun navigateToFriends() {
        navigation.replaceCurrent(StudentMainConfig.Friends)
    }

    fun navigateToMyPage() {
        navigation.replaceCurrent(StudentMainConfig.MyPage)
    }

    fun navigateBack() {
        navigation.pop()
    }
}