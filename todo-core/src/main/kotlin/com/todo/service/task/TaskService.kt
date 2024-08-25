package com.todo.service.task

import arrow.core.Either
import com.todo.model.TaskPostRequest

interface TaskService {
    suspend fun storeTask(request: TaskPostRequest): Either<StoreTaskProblem, Unit>
}

sealed interface StoreTaskProblem {
    data object TaskNotFound : StoreTaskProblem
    data object TaskNotAllowed : StoreTaskProblem
}