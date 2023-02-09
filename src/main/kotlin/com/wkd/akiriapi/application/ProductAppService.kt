package com.wkd.akiriapi.application

import com.wkd.akiriapi.annotation.Logger
import com.wkd.akiriapi.annotation.Logger.Companion.logger
import com.wkd.akiriapi.domain.model.product.Product
import com.wkd.akiriapi.domain.model.product.ProductRepository
import com.wkd.akiriapi.domain.model.product.param.ProductParam
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
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

    fun createByUrl(url : String): Product {
        logger.info("ProductAppService -> createByUrl()")
        val doc: Document = Jsoup.connect(url).get()
        var param : ProductParam

        if(url.contains("product.29cm.co.kr")) {
            param = htmlParsingFrom29cm(doc, url)
        } else{
            param = htmlParsingFromOhou(doc,url)
        }

        val product = Product(
            param = param
        )
        repository.save(product)
        return product
    }

    fun htmlParsingFrom29cm(doc: Document, url: String) : ProductParam {
        val platform = "29cm"
        val brand =
            doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1ux6qe5.evt9g3e5 > div > a > div > h3").text()
        val title =
            doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-e9pho6.e1lehz0e1 > div:nth-child(1) > h2")
                .text()
        val imageUrl = doc.select("img.ewptmlp5").attr("src")
        val category = doc.select("span.e1lurd2z3:nth-child(2)").text()
        val retailPrice =
            doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > p.css-1bci2fm.ent7twr1")
                .text().replace(",", "")
        val salePrice =
            doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > div > div:nth-child(1) > span.css-4bcxzt.ent7twr4")
                .text().replace(",", "").replace(" 원", "")
        val discountRate =
            doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > div > div:nth-child(1) > span.css-pnhbjr.ent7twr2")
                .text().replace("%", "")

        val param = ProductParam(
            url = url,
            platform = platform,
            brand = brand,
            title = title,
            imageUrl = imageUrl,
            category = category,
            retailPrice = retailPrice.toBigDecimal(),
            salePrice = salePrice.toBigDecimal(),
            discountRate = discountRate.toInt()
        )

        logger.info("param = ", param)

        return param
    }

    fun htmlParsingFromOhou(doc: Document, url: String) : ProductParam {
        val platform = "오늘의집"
        val brand = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__content.col-12.col-md-6.col-lg-5 > div.production-selling-header > h1 > p > a").text()
        val title = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__content.col-12.col-md-6.col-lg-5 > div.production-selling-header > h1 > div > span").text()
        val imageUrl = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__cover-image-wrap.col-12.col-md-6.col-lg-7 > div > div.carousel.production-selling-cover-image.production-selling-overview__cover-image > div.carousel__list-wrap.production-selling-cover-image__carousel-wrap > div > div > img").attr("src")
        val category = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > nav > ol > li:nth-child(1) > a").text()
        val retailPrice = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__content.col-12.col-md-6.col-lg-5 > div.production-selling-header > div.production-selling-header__content > div > span > del > span.number").text().replace(",", "")
        val salePrice = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__content.col-12.col-md-6.col-lg-5 > div.production-selling-header > div.production-selling-header__content > div > span > span.production-selling-header__price__price > span.number").text().replace(",", "")
        val discountRate = doc.select("body > div.page > div > div > div.production-selling > div.production-selling-overview.container > div > div.production-selling-overview__content.col-12.col-md-6.col-lg-5 > div.production-selling-header > div.production-selling-header__content > div > span > span.production-selling-header__price__discount > span.number").text()

        val param = ProductParam(
            url = url,
            platform = platform,
            brand = brand,
            title = title,
            imageUrl = imageUrl,
            category = category,
            retailPrice = retailPrice.toBigDecimal(),
            salePrice = salePrice.toBigDecimal(),
            discountRate = discountRate.toInt()
        )

        logger.info("param = ", param)

        return param
    }
}
