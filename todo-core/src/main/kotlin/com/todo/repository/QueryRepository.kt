package com.todo.repository

import com.todo.entity.Dual
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.NoRepositoryBean

/**
 * Interface that indicate read/write by queries
 */
@NoRepositoryBean
interface QueryRepository : R2dbcRepository<Dual, Long>