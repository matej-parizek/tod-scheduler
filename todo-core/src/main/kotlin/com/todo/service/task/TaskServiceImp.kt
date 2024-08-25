package com.todo.service.task

import arrow.core.Either
import com.todo.model.TaskPostRequest
import com.todo.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskServiceImp(
    val repository: TaskRepository
) : TaskService {
    override suspend fun storeTask(request: TaskPostRequest): Either<StoreTaskProblem, Unit> {
        repository.addTask(
            request.title,
            request.description
        )
        return Either.Right(Unit);
    }
}