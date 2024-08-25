package com.todo.service.version

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * Only returning version obtained from application
 */
@Service
data class VersionService(
    @Value("\${todo.app.version}")
    var version: String
)