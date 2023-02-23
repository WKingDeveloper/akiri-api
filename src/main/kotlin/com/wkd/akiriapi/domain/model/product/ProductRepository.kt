package com.wkd.akiriapi.domain.model.product

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product as p WHERE p.category = :category")
    fun findAllByFilter(@Param("category") category: ProductCategory, pageable: Pageable) : Page<Product>
}
