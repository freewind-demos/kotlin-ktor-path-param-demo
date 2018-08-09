package example

import io.ktor.application.call
import io.ktor.application.log
import io.ktor.request.uri
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            trace {
                application.log.debug("request uri: " + it.call.request.uri)
            }
            get("/demo1/{id}") {
                println(call.parameters)
                val id = call.parameters["id"]
                call.respondText("id: $id")
            }
            get("/demo2/{id?}") {
                println(call.parameters)
                val id = call.parameters["id"]
                call.respondText("id: $id")
            }
            get("/demo3/*/123") {
                println(call.parameters)
                call.respondText("route: /demo3/*/123")
            }
            get("/demo4/{...}") {
                println(call.parameters)
                call.respondText("route: /demo4/{...}")
            }
            get("/demo5/{tail...}") {
                println(call.parameters)
                val tail = call.parameters.getAll("tail")
                println(tail)
                call.respondText("tail: $tail")
            }
        }
    }
    server.start(wait = true)
}
