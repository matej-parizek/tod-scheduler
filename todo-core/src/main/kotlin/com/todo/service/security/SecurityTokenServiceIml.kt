package com.todo.service.security

import org.springframework.stereotype.Service

@Service
class SecurityTokenServiceIml : SecurityTokenService {
    override suspend fun getAuthorizedUser(credential: String): LoggedUser {
        throw UnsupportedOperationException("not implemented")
    }
}