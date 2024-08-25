package com.todo.controller

import arrow.core.Either
import com.todo.api.TaskApi
import com.todo.model.ModelApiResponse
import com.todo.model.TaskPostRequest
import com.todo.service.task.StoreTaskProblem
import com.todo.service.task.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    private val taskService: TaskService
): TaskApi{
    override suspend fun createTask(taskPostRequest: TaskPostRequest): ResponseEntity<ModelApiResponse> {
        return when (val result = taskService.storeTask(taskPostRequest)) {
            is Either.Right -> created()
            is Either.Left -> when (result.value){
                is StoreTaskProblem.TaskNotAllowed -> forbidden()
                is StoreTaskProblem.TaskNotFound -> notFound()
            }
        }
    }
}