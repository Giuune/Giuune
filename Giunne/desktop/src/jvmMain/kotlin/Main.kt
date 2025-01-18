import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.parcelable.ParcelableContainer
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
import com.badoo.reaktive.coroutinesinterop.asScheduler
import com.badoo.reaktive.scheduler.overrideSchedulers
import com.project.giunne.Res
import com.project.giunne.app_title
import com.project.giunne.common.di.sharedModule
import com.project.giunne.common.presentation.root.RootComponent
import com.project.giunne.common.presentation.root.RootContent
import com.project.giunne.common.ui.theme.GiunnaeTheme
import com.project.giunne.common.util.PreferencesUtil
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jetbrains.compose.resources.stringResource
import org.koin.core.context.startKoin
import util.runOnUiThread
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    PreferencesUtil.init()

    startKoin {
        modules(sharedModule)
    }

    Napier.base(DebugAntilog())

    overrideSchedulers(main = Dispatchers.Main::asScheduler)

    val lifecycle = LifecycleRegistry()
    val stateKeeper = StateKeeperDispatcher(tryRestoreStateFromFile())

    val root =
        runOnUiThread {
            RootComponent(
                componentContext = DefaultComponentContext(
                    lifecycle = lifecycle,
                    stateKeeper = stateKeeper,
                ),
            )
        }

    application {
        val windowState = rememberWindowState(
            width = 360.dp,
            height = 780.dp,
            position = WindowPosition(Alignment.TopEnd),
//            position = WindowPosition((-100).dp, 0.dp),
            isMinimized = false
        )

        Window(
            onCloseRequest = ::exitApplication,
            title = stringResource(Res.string.app_title) + " - 1.0.0",
            state = windowState
//            icon = BitmapPainter(useResource("drawable/ic_app.png", ::loadImageBitmap)),
//            resizable = false,
        ) {

//            windowState.size = DpSize(780.dp, 360.dp)

            GiunnaeTheme {
                RootContent(root)
            }
        }
    }
}

private const val SAVED_STATE_FILE_NAME = "saved_state.dat"

private fun saveStateToFile(state: ParcelableContainer) {
    ObjectOutputStream(File(SAVED_STATE_FILE_NAME).outputStream()).use { output ->
        output.writeObject(state)
    }
}

private fun tryRestoreStateFromFile(): ParcelableContainer? =
    File(SAVED_STATE_FILE_NAME).takeIf(File::exists)?.let { file ->
        try {
            ObjectInputStream(file.inputStream()).use(ObjectInputStream::readObject) as ParcelableContainer
        } catch (e: Exception) {
            null
        } finally {
            file.delete()
        }
    }