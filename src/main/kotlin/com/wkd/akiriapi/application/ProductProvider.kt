package com.wkd.akiriapi.application

import com.wkd.akiriapi.annotation.Logger
import com.wkd.akiriapi.annotation.Logger.Companion.logger
import com.wkd.akiriapi.domain.model.product.Product
import com.wkd.akiriapi.domain.model.product.ProductCategory
import com.wkd.akiriapi.domain.model.product.ProductFilter
import com.wkd.akiriapi.domain.model.product.ProductRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service


@Service
@Logger
class ProductProvider(
    private val repository: ProductRepository
){
    @Cacheable(value = ["a-product"], key = "#id")
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

    fun getListByFilter(
        filter : ProductFilter?,
        page: Int,
        size: Int
    ): Page<Product> {
        logger.info("ProductProvider -> getListByFilter()")

        val productFilter = filter ?: ProductFilter(category = "MAN")
        return repository.findAllByFilter(ProductCategory.fromValueByValue(productFilter.category),
            PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"))
        )
    }

}
