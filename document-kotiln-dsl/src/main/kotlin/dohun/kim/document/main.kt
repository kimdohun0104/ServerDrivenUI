package dohun.kim.document

import com.google.gson.Gson
import dohun.kim.document.data.document
import dohun.kim.document.enum.DataType
import dohun.kim.document.enum.Intent

fun main() {
    val document = document {

        component("FooButton") {
            description("This is a FooButton")

            content("text", DataType.STRING) {
                description("This is text")

                example("HelloWorld")
            }

            content("subText", DataType.STRING, nullable = true) {
                description("This is subText")

                example("SubText")
            }

            action(Intent.NAVIGATION) {
                description("This is navigation event to poo")

                data {
                    route("/poo")
                }
            }
        }

        component("PooListView", version = 3) {
            description("This is PooListView")


        }
    }

    println(Gson().toJson(document))
}