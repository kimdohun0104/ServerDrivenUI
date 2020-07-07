package dohun.kim.document.data

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@DslMarker
annotation class DocumentMarker

fun document(block: DocumentBuilder.() -> Unit): Document {
    return DocumentBuilder().apply(block).build()
}

data class Document(
    val components: ArrayList<Component>
)

@DocumentMarker
class DocumentBuilder {

    private var components: ArrayList<Component> = arrayListOf()

    fun component(componentName: String, version: Int = 0, block: @DocumentMarker ComponentBuilder.() -> Unit) {
        components.add(ComponentBuilder(componentName, version).apply(block).build())
    }

    fun build(): Document = Document(components)
}