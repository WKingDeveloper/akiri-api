package com.wkd.akiriapi.domain.model.product

enum class ProductCategory(
    val index: Int,
    val value: String
) {
    MAN(0,"MAN"),
    WOMAN(1,"WOMAN"),
    HOME_ELECTRONICS(2,"HOME_ELECTRONICS"),
    HOME_FURNISHINGS(3,"HOME_FURNISHINGS"),
    UNISEX(4,"UNISEX"),
    ETC(5,"ETC");

    companion object {

        val womanCategory = listOf("여성","여성의류","여성가방","여성신발","여성액세서리","여성악세사리","여성악세서리")
        val manCategory = listOf("남성","남성의류","남성가방","남성신발","남성액세서리","남성악세사리","남성악세서리")
        val homeElectronicsCategory = listOf("디지털","가전","디지털,가전","디지털/가전","컴퓨터,디지털","컴퓨터","노트북")
        val homeFurnishingsCategory = listOf("가구","인테리어","가구,인테리어","가구/인테리어")
        val unisexCategory = listOf("공용","의류","가방","신발","액세서리","악세사리","악세서리")

        val categories = listOf(manCategory, womanCategory, homeElectronicsCategory, homeFurnishingsCategory, unisexCategory)

        fun fromValueByIndex(value: String) :ProductCategory {
            var index = 5;
            for ((i, category) in categories.withIndex()){
                if(value in category){
                    index = i
                }
            }
            return ProductCategory.values().first{ it.index == index }
        }

        fun fromValueByValue(value: String): ProductCategory = ProductCategory.values().first { it.value == value }



    }

}
