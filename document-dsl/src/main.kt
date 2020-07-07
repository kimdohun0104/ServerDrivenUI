import data.document
import enum.DataType
import enum.Intent

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