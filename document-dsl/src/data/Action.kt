package data

import enum.Intent

data class Action(
    val pressEvent: PressEvent?
)

data class ActionData(
    val route: String?,
    val uri: String?
)

data class PressEvent(
    val intent: Intent,
    val data: ActionData
)