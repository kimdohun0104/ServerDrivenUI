package data

import enum.Intent

data class Action(
    val intent: Intent,
    val data: ActionData,
    val description: String?
)

data class ActionData(
    val route: String?,
    val uri: String?
)

class ActionBuilder(private val intent: Intent) {
    private lateinit var data: ActionData

    private var description: String? = null

    fun data(block: ActionDataBuilder.() -> Unit) {
        data = ActionDataBuilder().apply(block).build()
    }

    fun description(description: String) {
        this.description = description
    }

    fun build(): Action {
        return Action(intent, data, description)
    }
}

class ActionDataBuilder {

    private var route: String? = null
    private var uri: String? = null

    fun route(route: String) {
        this.route = route
    }

    fun uri(uri: String) {
        this.uri = uri
    }

    fun build(): ActionData {
        return ActionData(route, uri)
    }
}