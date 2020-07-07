package dohun.kim.document

import dohun.kim.document.data.document
import dohun.kim.document.enum.DataType
import dohun.kim.document.enum.Intent

fun main() {
    val document = document {

        component("FooButton") {
            description("This is a FooButton")

            content("text", DataType.STRING) {
                description("This is a button text")

                example("HelloWorld")
            }

            action(Intent.NAVIGATION) {
                description("This is navigation event to poo")

                data {
                    route("/poo")
                }
            }
        }
    }

    println(document.toString())
}