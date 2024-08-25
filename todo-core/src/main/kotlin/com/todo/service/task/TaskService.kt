package com.todo.service.task

import arrow.core.Either
import com.todo.model.TaskPostRequest

interface TaskService {
    /**
     * Add new task to to-do list
     * @param request is taskDto from controller
     */
    suspend fun storeTask(request: TaskPostRequest): Either<StoreTaskProblem, Unit>
}

/**
 * Error state of the task, which service can return
 */
sealed interface StoreTaskProblem {
    data object TaskNotFound : StoreTaskProblem
    data object TaskNotAllowed : StoreTaskProblem
}