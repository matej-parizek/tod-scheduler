package com.todo.service.security

sealed interface LoggedUser {
    val username: String
}

data class SecuredLoggedUser(
    override val username: String
):LoggedUser

data object AnonymousLoggedUser: LoggedUser {
    override val username: String
        get() = throw UnsupportedOperationException("Anonymous user")
}