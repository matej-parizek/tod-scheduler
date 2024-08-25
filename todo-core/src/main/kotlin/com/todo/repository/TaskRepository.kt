package com.todo.repository

import com.todo.entity.TaskRecord
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : QueryRepository {

    @Modifying
    @Query(
        """
        INSERT INTO
            TASK(
                LABEL,
                DESCRIPTION,
            )
        VALUES(
            :label
            :description
        )
    """
    )
    suspend fun addTask(
        @Param("label") label: String,
        @Param("description") description: String,
    )
}