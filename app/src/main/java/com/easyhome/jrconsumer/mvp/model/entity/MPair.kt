package com.easyhome.jrconsumer.mvp.model.entity

import java.io.Serializable

/**
 * Time 2018/10/12  5:24 PM
 *
 * Pair
 **/
data class MPair<A, B>(
    var first: A,
    var second: B
) : Serializable