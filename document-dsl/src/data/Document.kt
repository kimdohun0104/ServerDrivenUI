package data

fun document(block: DocumentBuilder.() -> Unit): Document {
    return DocumentBuilder().apply(block).build()
}

data class Document(
    val components: ArrayList<Component>
)

class DocumentBuilder {

    private var components: ArrayList<Component> = arrayListOf()

    fun component(componentName: String, block: ComponentBuilder.() -> Unit) {
        components.add(ComponentBuilder(componentName).apply(block).build())
    }

    fun build(): Document = Document(components)
}