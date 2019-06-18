package com.rightpoint.domain.models

actual fun createRandomInt(vararg max: Int): Int {
    return ((Math.random() * max[0])).toInt()
}