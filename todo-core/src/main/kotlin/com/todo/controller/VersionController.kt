package com.todo.controller

import com.todo.api.VersionApi
import com.todo.service.version.VersionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class VersionController(
    private val versionService: VersionService
) : VersionApi {
    override suspend fun version(): ResponseEntity<String> {
        return ok(
            versionService.version
        )
    }
}
