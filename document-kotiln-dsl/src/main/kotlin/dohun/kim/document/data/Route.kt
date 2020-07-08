package dohun.kim.document.data

import dohun.kim.document.enum.DataType

data class Route(
    val route: String,
    val arguments: List<Pair<String, DataType>>
)

class RouteBuilder(private val route: String) {

    private val arguments: ArrayList<Pair<String, DataType>> = arrayListOf()

    fun argument(name: String, dataType: DataType) {
        arguments.add(name to dataType)
    }

    fun build(): Route {
        return Route(route, arguments)
    }
}