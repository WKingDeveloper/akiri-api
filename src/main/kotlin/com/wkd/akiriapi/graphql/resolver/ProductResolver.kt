package com.wkd.akiriapi.graphql.resolver

import com.frientrip.product.graphql.relay.Connection
import com.netflix.graphql.dgs.*
import com.wkd.akiriapi.annotation.Logger
import com.wkd.akiriapi.annotation.Logger.Companion.logger
import com.wkd.akiriapi.application.ProductProvider
import com.wkd.akiriapi.domain.model.product.Product
import com.wkd.akiriapi.util.PagingTool

@DgsComponent
@Logger
class ProductResolver(
    val productProvider: ProductProvider
) {

    @DgsQuery
    fun product(@InputArgument id: Long, env: DgsDataFetchingEnvironment): Product {
        logger.info("ProductResolver -> product()")
        return productProvider.get(id)
    }


    @DgsQuery
    fun products(
        env: DgsDataFetchingEnvironment,
        @InputArgument page: Int? = 1,
        @InputArgument size: Int? = 10,
    ): Connection<Product> {
        logger.info("ProductResolver -> products()")
        val products = productProvider.getList(
            page = page ?: 1,
            size = size ?: 10
        );

        val productConnection = Connection(
            products
        ) {
            PagingTool.convertToCursor(Product::class.java.simpleName, it.id)
        }
        return productConnection
    }

    @DgsQuery
    fun id(env: DgsDataFetchingEnvironment) = env.getSource<Product>().id

    @DgsQuery
    fun platform(env: DgsDataFetchingEnvironment) = env.getSource<Product>().platform

    @DgsQuery
    fun url(env: DgsDataFetchingEnvironment) = env.getSource<Product>().url

    @DgsQuery
    fun brand(env: DgsDataFetchingEnvironment) = env.getSource<Product>().brand

    @DgsQuery
    fun title(env: DgsDataFetchingEnvironment) = env.getSource<Product>().title

    @DgsQuery
    fun imageUrl(env: DgsDataFetchingEnvironment) = env.getSource<Product>().imageUrl

    @DgsQuery
    fun category(env: DgsDataFetchingEnvironment) = env.getSource<Product>().category

    @DgsQuery
    fun currencyCode(env: DgsDataFetchingEnvironment) = env.getSource<Product>().currencyCode

    @DgsQuery
    fun retailPrice(env: DgsDataFetchingEnvironment) = env.getSource<Product>().retailPrice

    @DgsQuery
    fun salePrice(env: DgsDataFetchingEnvironment) = env.getSource<Product>().salePrice

    @DgsQuery
    fun discountRate(env: DgsDataFetchingEnvironment) = env.getSource<Product>().discountRate

    @DgsQuery
    fun status(env: DgsDataFetchingEnvironment) = env.getSource<Product>().status

    @DgsQuery
    fun createdAt(env: DgsDataFetchingEnvironment) = env.getSource<Product>().createdAt

    @DgsQuery
    fun updatedAt(env: DgsDataFetchingEnvironment) = env.getSource<Product>().updatedAt

}
