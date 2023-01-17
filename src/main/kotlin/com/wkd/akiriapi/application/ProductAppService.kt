package com.wkd.akiriapi.application

import com.wkd.akiriapi.annotation.Logger
import com.wkd.akiriapi.annotation.Logger.Companion.logger
import com.wkd.akiriapi.domain.model.product.Product
import com.wkd.akiriapi.domain.model.product.ProductRepository
import com.wkd.akiriapi.domain.model.product.param.ProductParam
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
@Logger
class ProductAppService(
    private val repository: ProductRepository
){
    fun create(param: ProductParam): Product {
        logger.info("ProductAppService -> create()")
        val product = Product(
            param = param
        )
        repository.save(product)
        return product
    }
}