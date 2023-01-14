package com.wkd.akiriapi.application

import com.wkd.akiriapi.model.product.Product
import com.wkd.akiriapi.model.product.ProductRepository
import org.springframework.stereotype.Service


@Service
class ProductProvider(
    private val repository: ProductRepository
){
    fun get(id: Long): Product {
        val product = repository.findById(id).orElseThrow { RuntimeException("해당 상품을 찾지 못하였습니다.") }
        return product
    }

    fun getAll(): List<Product> {
        return repository.findAll()
    }

}