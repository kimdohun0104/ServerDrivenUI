package dohun.kim.document.data

import dohun.kim.document.enum.Intent
import jdk.nashorn.internal.objects.NativeFunction.apply

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
@DslMarker
annotation class ActionMarker

data class Action(
    val intent: Intent,
    val data: ActionData,
    val description: String?
)

data class ActionData(
    val route: String?,
    val uri: String?
)

@ActionMarker
class ActionBuilder(private val intent: Intent) {
    private lateinit var data: ActionData

    private var description: String? = null

    fun data(block: @ActionMarker ActionDataBuilder.() -> Unit) {
        data = ActionDataBuilder().apply(block).build()
    }

    fun description(@ActionMarker description: String) {
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