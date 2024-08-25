package com.todo.entity

import org.springframework.data.relational.core.mapping.Table

/**
 * Simulate basic Oracle table that allows performing
 * db functions and operations.
 * */
@Table("DUAL")
data class Dual(
    val value: String,
)
