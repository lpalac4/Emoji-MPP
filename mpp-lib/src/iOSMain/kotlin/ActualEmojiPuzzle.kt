package com.rightpoint.domain.emoji

import kotlin.random.Random

actual fun createRandomInt(vararg max: Int): Int {
    return Random.nextInt(0, max[0])
}