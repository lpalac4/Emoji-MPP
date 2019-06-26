package com.rightpoint.domain.emoji

actual fun createRandomInt(vararg max: Int): Int {
    return ((Math.random() * max[0])).toInt()
}