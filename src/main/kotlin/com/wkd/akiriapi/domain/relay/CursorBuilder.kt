package com.frientrip.product.graphql.relay

fun interface CursorBuilder<T> {
    fun build(arg: T): String
}