package com.sdr.products.core.action

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Application.main() {
    install(CallLogging)
    install(Routing) {
        get("/hello") {
            call.respond("Hello world from Ktor!")
        }
    }
}