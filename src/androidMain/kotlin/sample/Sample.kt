package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class Sample {
    actual fun checkMe() =42
}

actual object Platform {
    actual fun name(): String = "Android"
}
