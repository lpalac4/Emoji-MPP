package com.rightpoint.repository

import com.rightpoint.repository.models.PuzzleEntity
import kotlin.reflect.KClass

actual fun parseFileToPuzzleEntity(kClass: KClass<PuzzleEntity>, fileName: String): PuzzleEntity {
    return PuzzleEntity(listOf())
}