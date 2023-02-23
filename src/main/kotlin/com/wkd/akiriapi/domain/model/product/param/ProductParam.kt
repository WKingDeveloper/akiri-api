package com.wkd.akiriapi.domain.model.product.param

import com.wkd.akiriapi.domain.model.product.CurrencyCode
import com.wkd.akiriapi.domain.model.product.ProductCategory
import com.wkd.akiriapi.domain.model.product.ProductState
import java.math.BigDecimal

data class ProductParam(

    /**
     * 상품 판매 플랫폼
     */
    val platform: String,

    /**
     * 상품 판매 url
     */
    val url: String,

    /**
     * 상품 브랜드
     */
    val brand: String,

    /**
     * 상품명
     */
    val title: String,

    /**
     * 상품 이미지 url
     */
    val imageUrl: String,

    /**
     * 상품 아키리 카테고리
     */
    var category: ProductCategory,

    /**
     * 상품 원본 카테고리
     */
    var originCategory: String,

    /**
     * 상품 통화 코드
     */
    var currencyCode: CurrencyCode = CurrencyCode.KRW,

    /**
     * 상품 정상 가격
     */
    var retailPrice: BigDecimal,

    /**
     * 상품 판매 가격
     */
    var salePrice: BigDecimal,

    /**
     * 상품 판매 가격
     */
    var discountRate: Int,

    /**
     * 상품 상태
     */
    var status: ProductState = ProductState.SALE,

    )
