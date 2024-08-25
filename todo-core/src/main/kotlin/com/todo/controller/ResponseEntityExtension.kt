package com.todo.controller

import com.todo.model.ModelApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

// UNAUTHORIZED response
@JvmName("unauthorizedDefault")
fun <T> unauthorized(): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .build()


//OK response
fun <T> ok(block: () -> T): ResponseEntity<T> = ResponseEntity.ok(block())
fun <T> ok(body: T): ResponseEntity<T> = ResponseEntity.ok(body)

// CREATED response
fun <T> created(): ResponseEntity<T> = ResponseEntity.status(HttpStatus.CREATED).build()

// FORBIDDEN response
fun forbidden(): ResponseEntity<ModelApiResponse> =
    ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body(
            ModelApiResponse(
                code = HttpStatus.FORBIDDEN.value(),
                type = ModelApiResponse.Type.fORBIDDEN,
            ),
        )
fun notFound(): ResponseEntity<ModelApiResponse> = ResponseEntity.status(HttpStatus.NOT_FOUND)
    .body(
        ModelApiResponse(
            code = HttpStatus.NOT_FOUND.value(),
            type = ModelApiResponse.Type.nOTFOUND
        )
    )