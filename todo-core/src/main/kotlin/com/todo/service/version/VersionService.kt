package com.todo.service.version

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
data class VersionService(
    @Value("\${todo.app.version}")
    var version: String
)