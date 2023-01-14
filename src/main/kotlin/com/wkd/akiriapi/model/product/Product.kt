package com.wkd.akiriapi.model.product

import com.wkd.akiriapi.model.EntityBase
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    /**
     * 상품 판매 플랫폼
     */
    @Column
    val platform: String,

    /**
     * 상품 판매 url
     */
    @Column
    val url: String,

    /**
     * 상품 브랜
     */
    @Column
    val brand: String,

    /**
     * 상품명
     */
    @Column
    val title: String,

    /**
     * 상품 이미지 url
     */
    @Column
    val imageUrl: String,

    /**
     * 상품 카테고리
     */
    @Column
    var category: String,

    /**
     * 상품 통화 코드
     */
    @Enumerated(EnumType.STRING)
    @Column
    var currencyCode: CurrencyCode,

    /**
     * 상품 정상 가격
     */
    @Column
    var retailPrice: BigDecimal,

    /**
     * 상품 판매 가격
     */
    @Column
    var salePrice: BigDecimal,

    /**
     * 상품 판매 가격
     */
    @Column
    var discountRate: Int,

    /**
     * 상품 상태
     */
    @Enumerated(EnumType.STRING)
    @Column
    var status: ProductState,


    ) : EntityBase(), Serializable