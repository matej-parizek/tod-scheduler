package com.todo.controller

import com.todo.service.security.AnonymousLoggedUser
import com.todo.service.security.LoggedUser
import com.todo.service.security.SecuredLoggedUser
import com.todo.service.security.SecurityTokenService
import org.springframework.http.ResponseEntity

//TODO: add authorization (create oauth2)
open class BaseController(
    val security: SecurityTokenService
) {
    protected suspend inline fun <T> authorization(
        authorization: String,
        block: (logged: LoggedUser) -> ResponseEntity<T>
    ): ResponseEntity<T> {
        return when (val user = security.getAuthorizedUser(authorization)) {
            is SecuredLoggedUser -> block(user)
            AnonymousLoggedUser -> unauthorized()
        }
    }
}