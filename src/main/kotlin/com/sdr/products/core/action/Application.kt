package com.sdr.products.core.action

import com.fasterxml.jackson.databind.SerializationFeature
import com.sdr.products.core.message.Item
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Application.main() {
    install(CallLogging)

    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }

    install(Routing) {
        get("/hello") {
            call.respond("Hello world from Ktor!")
        }

        get("/item") {
            call.respond(Item(number = 1, name = "Hoge"))
        }
    }
}