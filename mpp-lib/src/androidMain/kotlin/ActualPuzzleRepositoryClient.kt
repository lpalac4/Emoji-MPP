package com.rightpoint.repository

import com.rightpoint.repository.models.PuzzleEntity
import java.io.InputStreamReader
import com.google.gson.Gson
import kotlin.reflect.KClass

private val gson = Gson()

actual fun parseFileToPuzzleEntity(kClass: KClass<PuzzleEntity>, fileName: String): PuzzleEntity {
    val input = kClass.java.classLoader.getResourceAsStream("emojipuzzles.json")
    val reader = InputStreamReader(input, "UTF-8")
    return gson.fromJson(reader, PuzzleEntity::class.java)
}