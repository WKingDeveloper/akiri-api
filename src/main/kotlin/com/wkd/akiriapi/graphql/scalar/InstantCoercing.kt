package com.wkd.akiriapi.graphql.scalar

import com.netflix.graphql.dgs.DgsScalar
import graphql.language.IntValue
import graphql.schema.Coercing
import graphql.schema.CoercingSerializeException
import java.time.Instant

@DgsScalar(name = "Instant")
class InstantCoercing : Coercing<Instant, Long> {
    override fun parseValue(input: Any): Instant = parseInstant(serialize(input))

    override fun parseLiteral(input: Any): Instant = when (input) {
        is IntValue -> parseInstant(input.value.toLong())
        is Long -> parseInstant(input)
        is Int -> parseInstant(input.toLong())
        else -> Instant.now()
    }

    override fun serialize(dataFetcherResult: Any): Long = when (dataFetcherResult) {
        is Instant -> dataFetcherResult.toEpochMilli()
        else -> dataFetcherResult.toString().toLong()
    }

    private fun parseInstant(literal: Long): Instant = try {
        Instant.ofEpochMilli(literal)
    } catch (e: Exception) {
        throw CoercingSerializeException("Could not parse Epoch milli number: $e")
    }
}
