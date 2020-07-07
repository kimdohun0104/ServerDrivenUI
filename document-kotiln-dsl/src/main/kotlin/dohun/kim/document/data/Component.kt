package dohun.kim.document.data

import dohun.kim.document.enum.DataType
import dohun.kim.document.enum.Intent

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@DslMarker
annotation class ComponentMarker

data class Component(
    val componentName: String,
    val content: Content,
    val version: Int,
    val description: String?,
    val action: Action?
)

@ComponentMarker
class ComponentBuilder(
    private val componentName: String,
    private val version: Int
) {

    private lateinit var content: Content

    private var description: String? = null
    private var action: Action? = null

    fun description(@ComponentMarker description: String) {
        this.description = description
    }

    fun content(name: String, dataType: DataType, nullable: Boolean = false, block: @ComponentMarker ContentBuilder.() -> Unit) {
        content = ContentBuilder(name, dataType, nullable).apply(block).build()
    }

    fun action(intent: Intent, block: @ComponentMarker ActionBuilder.() -> Unit) {
        action = ActionBuilder(intent).apply(block).build()
    }

    fun build(): Component = Component(componentName, content, version, description, action)
}