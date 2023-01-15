package com.wkd.akiriapi.graphql.mutation

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument
import com.wkd.akiriapi.application.ProductAppService
import com.wkd.akiriapi.model.product.param.ProductParam

@DgsComponent
class ProductMutation(
    private val service: ProductAppService,
) {
    @DgsMutation
    fun createProduct(
        env: DgsDataFetchingEnvironment,
        @InputArgument param: ProductParam
    ) = service.create(
        param
    )

}
