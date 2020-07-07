package dohun.kim.document.data

import dohun.kim.document.enum.DataType

data class Content(
    val name: String,
    val dataType: DataType,
    val nullable: Boolean,
    val description: String?,
    val example: List<Any>
)

class ContentBuilder(
    private val name: String,
    private val dataType: DataType,
    private val nullable: Boolean
) {
    private val example: ArrayList<Any> = arrayListOf()

    private var description: String? = null

    fun description(description: String) {
        this.description = description
    }

    fun example(example: Any) {
        this.example.add(example)
    }

    fun build(): Content =
        Content(name, dataType, nullable, description, example)
}