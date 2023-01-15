package com.wkd.akiriapi.model.product.param

import com.wkd.akiriapi.model.product.CurrencyCode
import com.wkd.akiriapi.model.product.ProductState
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
     * 상품 카테고리
     */
    var category: String,

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