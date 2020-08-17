import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.Application
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.util.KtorExperimentalAPI

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText("hello, world")
        }
    }
}

@KtorExperimentalAPI
fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    embeddedServer(CIO, port, watchPaths = listOf("build"), module = Application::module).start(true)
}
