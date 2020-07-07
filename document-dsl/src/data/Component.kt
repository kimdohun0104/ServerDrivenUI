package data

import enum.DataType
import enum.Intent

data class Component(
    val componentName: String,
    val content: Content,
    val description: String?,
    val action: Action?
)

class ComponentBuilder(private val componentName: String) {

    private lateinit var content: Content

    private var description: String? = null
    private var action: Action? = null

    fun description(description: String) {
        this.description = description
    }

    fun content(name: String, dataType: DataType, block: ContentBuilder.() -> Unit) {
        content = ContentBuilder(name, dataType).apply(block).build()
    }

    fun action(intent: Intent, block: ActionBuilder.() -> Unit) {
        action = ActionBuilder(intent).apply(block).build()
    }

    fun build(): Component = Component(componentName, content, description, action)
}