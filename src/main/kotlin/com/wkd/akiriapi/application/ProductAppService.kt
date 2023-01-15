package com.wkd.akiriapi.application

import com.wkd.akiriapi.model.product.Product
import com.wkd.akiriapi.model.product.ProductRepository
import com.wkd.akiriapi.model.product.param.ProductParam
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class ProductAppService(
    private val repository: ProductRepository
){
    fun create(param: ProductParam): Product {
        val product = Product(
            param = param
        )
        repository.save(product)
        return product
    }
}