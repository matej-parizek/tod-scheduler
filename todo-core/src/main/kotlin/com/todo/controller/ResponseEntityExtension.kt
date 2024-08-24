package com.todo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

// UNAUTHORIZED response
@JvmName("unauthorizedDefault")
fun <T> unauthorized(): ResponseEntity<T> =
    ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .build()


//OK response
fun <T> ok(block: ()->T): ResponseEntity<T> = ResponseEntity.ok(block())
fun <T> ok(body: T): ResponseEntity<T> = ResponseEntity.ok(body)
