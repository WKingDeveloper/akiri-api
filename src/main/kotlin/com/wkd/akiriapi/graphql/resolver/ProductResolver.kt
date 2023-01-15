package com.wkd.akiriapi.graphql.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.InputArgument
import com.wkd.akiriapi.application.ProductProvider
import com.wkd.akiriapi.model.product.Product

@DgsComponent
class ProductResolver(
    val productProvider: ProductProvider
) {
    companion object {
        const val TYPE_NAME = "Query"
    }

    @DgsData(parentType = TYPE_NAME, field = "product")
    fun product(@InputArgument id: Long, env: DgsDataFetchingEnvironment): Product {
        println("ProductResolver -> product")
        return productProvider.get(id)
    }


    @DgsData(parentType = TYPE_NAME, field = "products")
    fun products(env: DgsDataFetchingEnvironment): List<Product> {
        println("ProductResolver -> products")
        return productProvider.getAll()
    }


    @DgsData(parentType = TYPE_NAME)
    fun id(env: DgsDataFetchingEnvironment) = env.getSource<Product>().id

    @DgsData(parentType = TYPE_NAME)
    fun platform(env: DgsDataFetchingEnvironment) = env.getSource<Product>().platform

    @DgsData(parentType = TYPE_NAME)
    fun url(env: DgsDataFetchingEnvironment) = env.getSource<Product>().url

    @DgsData(parentType = TYPE_NAME)
    fun brand(env: DgsDataFetchingEnvironment) = env.getSource<Product>().brand

    @DgsData(parentType = TYPE_NAME)
    fun title(env: DgsDataFetchingEnvironment) = env.getSource<Product>().title

    @DgsData(parentType = TYPE_NAME)
    fun imageUrl(env: DgsDataFetchingEnvironment) = env.getSource<Product>().imageUrl

    @DgsData(parentType = TYPE_NAME)
    fun category(env: DgsDataFetchingEnvironment) = env.getSource<Product>().category

    @DgsData(parentType = TYPE_NAME)
    fun currencyCode(env: DgsDataFetchingEnvironment) = env.getSource<Product>().currencyCode

    @DgsData(parentType = TYPE_NAME)
    fun retailPrice(env: DgsDataFetchingEnvironment) = env.getSource<Product>().retailPrice

    @DgsData(parentType = TYPE_NAME)
    fun salePrice(env: DgsDataFetchingEnvironment) = env.getSource<Product>().salePrice

    @DgsData(parentType = TYPE_NAME)
    fun discountRate(env: DgsDataFetchingEnvironment) = env.getSource<Product>().discountRate

    @DgsData(parentType = TYPE_NAME)
    fun status(env: DgsDataFetchingEnvironment) = env.getSource<Product>().status

    @DgsData(parentType = TYPE_NAME)
    fun createdAt(env: DgsDataFetchingEnvironment) = env.getSource<Product>().createdAt

    @DgsData(parentType = TYPE_NAME)
    fun updatedAt(env: DgsDataFetchingEnvironment) = env.getSource<Product>().updatedAt

}
