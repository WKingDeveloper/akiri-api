package com.wkd.akiriapi.application

import com.wkd.akiriapi.annotation.Logger
import com.wkd.akiriapi.annotation.Logger.Companion.logger
import com.wkd.akiriapi.domain.model.product.Product
import com.wkd.akiriapi.domain.model.product.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service


@Service
@Logger
class ProductProvider(
    private val repository: ProductRepository
){
    fun get(id: Long): Product {
        logger.info("ProductProvider -> get()")
        return repository.findById(id).orElseThrow { RuntimeException("해당 상품을 찾지 못하였습니다.") }
    }

    fun getList(
        page: Int,
        size: Int
    ): Page<Product> {
        logger.info("ProductProvider -> getList()")
        return repository.findAll(
            PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"))
        )
    }

}