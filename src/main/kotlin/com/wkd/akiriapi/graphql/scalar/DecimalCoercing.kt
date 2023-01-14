package com.wkd.akiriapi.graphql.scalar

import com.netflix.graphql.dgs.DgsScalar
import graphql.language.FloatValue
import graphql.language.IntValue
import graphql.language.StringValue
import graphql.schema.Coercing
import java.math.BigDecimal

@DgsScalar(name = "Decimal")
class DecimalCoercing : Coercing<BigDecimal, String> {
    override fun parseValue(input: Any): BigDecimal = BigDecimal.valueOf(serialize(input).toDouble())

    override fun parseLiteral(input: Any): BigDecimal {
        val decimal = when (input) {
            is StringValue -> input.value
            is IntValue -> input.value.toString()
            is FloatValue -> input.value.toString()
            else -> null
        }
        return decimal?.let { BigDecimal.valueOf(it.toDouble()) } ?: BigDecimal.ZERO
    }

    override fun serialize(dataFetcherResult: Any): String = dataFetcherResult.toString()
}