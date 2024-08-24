package com.todo.service.security

interface SecurityTokenService {
    suspend fun getAuthorizedUser(credential : String) : LoggedUser
}