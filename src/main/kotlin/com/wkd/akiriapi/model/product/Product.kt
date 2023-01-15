package com.wkd.akiriapi.model.product

import com.wkd.akiriapi.model.EntityBase
import com.wkd.akiriapi.model.product.param.ProductParam
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*

@Entity
class Product(
    param: ProductParam
    ) : EntityBase(), Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    /**
     * 상품 판매 플랫폼
     */
    @Column
    var platform: String = param.platform
        protected set

    /**
     * 상품 판매 url
     */
    @Column
    var url: String = param.url
        protected set

    /**
     * 상품 브랜드
     */
    @Column
    var brand: String = param.brand
        protected set

    /**
     * 상품명
     */
    @Column
    var title: String = param.title
        protected set

    /**
     * 상품 이미지 url
     */
    @Column
    var imageUrl: String = param.imageUrl
        protected set

    /**
     * 상품 카테고리
     */
    @Column
    var category: String = param.category
        protected set

    /**
     * 상품 통화 코드
     */
    @Enumerated(EnumType.STRING)
    @Column
    var currencyCode: CurrencyCode = param.currencyCode
        protected set

    /**
     * 상품 정상 가격
     */
    @Column
    var retailPrice: BigDecimal = param.retailPrice
        protected set

    /**
     * 상품 판매 가격
     */
    @Column
    var salePrice: BigDecimal = param.salePrice
        protected set

    /**
     * 상품 판매 가격
     */
    @Column
    var discountRate: Int = param.discountRate
        protected set

    /**
     * 상품 상태
     */
    @Enumerated(EnumType.STRING)
    @Column
    var status: ProductState = param.status
        protected set

}
