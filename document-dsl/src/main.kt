import data.document
import enum.DataType

fun main() {
    val document = document {
        component("FooButton") {
            description("This is a FooButton")

            content("text", DataType.STRING) {
                description("This is a button text")

                example("HelloWorld")
            }
        }
    }

    println(document.toString())
}