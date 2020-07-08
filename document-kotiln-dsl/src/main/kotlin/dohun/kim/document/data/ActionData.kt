package dohun.kim.document.data

@Target(AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
@DslMarker
annotation class ActionDataMarker

data class ActionData(
    val route: Route?,
    val uri: String?
)

@ActionDataMarker
class ActionDataBuilder {

    private var route: Route? = null
    private var uri: String? = null

    fun route(route: String, block: @ActionDataMarker RouteBuilder.() -> Unit) {
        this.route = RouteBuilder(route).apply(block).build()
    }

    fun uri(@ActionDataMarker uri: String) {
        this.uri = uri
    }

    fun build(): ActionData {
        return ActionData(route, uri)
    }
}
