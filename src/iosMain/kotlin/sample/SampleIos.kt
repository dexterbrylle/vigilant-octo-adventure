package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual fun name(): String = "iOS"
}

