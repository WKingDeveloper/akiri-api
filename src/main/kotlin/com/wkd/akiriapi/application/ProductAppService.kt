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
        val platform = "29cm"
        val brand = doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1ux6qe5.evt9g3e5 > div > a > div > h3").text()
        val title = doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-e9pho6.e1lehz0e1 > div:nth-child(1) > h2").text()
        val imageUrl = doc.select("img.ewptmlp5").attr("src")
        val category = doc.select("span.e1lurd2z3:nth-child(2)").text()
        val retailPrice = doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > p.css-1bci2fm.ent7twr1").text().replace(",","")
        val salePrice = doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > div > div:nth-child(1) > span.css-4bcxzt.ent7twr4").text().replace(",","").replace(" 원","")
        val discountRate = doc.select("#__next > div.css-125q81m.evt9g3e1 > div.css-1y47rmj.e14czvjs0 > div.css-1i9d63n.e14czvjs1 > div.css-1ordngx.e1lehz0e0 > div.css-lcoy4n.e1lehz0e6 > div > div > div:nth-child(1) > span.css-pnhbjr.ent7twr2").text().replace("%","")

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

        logger.info("param = " , param)
        val product = Product(
            param = param
        )
        repository.save(product)
        return product
    }
}
