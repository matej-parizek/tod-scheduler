package com.todo.entity

import org.springframework.data.annotation.Immutable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Immutable
data class TaskRecord(
    @field:Column(ID)
    val id: Long,
    @field:Column(TITLE)
    val title: String,
    @field:Column(DESCRIPTION)
    val description: String,
){
    companion object{
        const val ID = "TASK_ID"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
    }
}