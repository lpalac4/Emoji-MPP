package com.rightpoint.repository

import com.rightpoint.repository.models.PuzzleEntity
import platform.posix.*
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

@UseExperimental(UnstableDefault::class)
actual fun parseFileToPuzzleEntity(kClass: KClass<PuzzleEntity>, fileName: String): PuzzleEntity {

//    var result = ""
//    val file = fopen(fileName, "r")
//
//
//    fseek(file, 0, SEEK_END)
//    val fileSize = ftello(file)
//    fseek(file, 0, SEEK_SET)
//
//    memScoped {
//        val buffer = allocArray<ByteVar>(fileSize.toInt())
//        fread(buffer, fileSize.toULong(), 1, file)
//        result = buffer.toKString()
//    }
//
//    fclose(file)

    var result = "{\n" +
            "  \"emojiPuzzles\": [\n" +
            "    {\n" +
            "      \"message\": \"\\uD83D\\uDD25\\uD83D\\uDCF2\\uD83D\\uDC8D\\uD83D\\uDC8E\",\n" +
            "      \"solution\": \"Hotline Bling\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"\\uD83C\\uDF2C️\\uD83C\\uDF2C️\\uD83D\\uDCB5\\uD83D\\uDCB5\\uD83D\\uDCB8\",\n" +
            "      \"solution\": \"Money to Blow\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"\\uD83D\\uDCAA\\uD83C\\uDFFD1️⃣\\uD83C\\uDFC5\\uD83D\\uDCAF\",\n" +
            "      \"solution\": \"Champion\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"\\uD83D\\uDD2A\\uD83C\\uDF4D\\uD83C\\uDF4D\\uD83D\\uDDE1️\",\n" +
            "      \"solution\": \"Diced Pineapples\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"\\uD83D\\uDECF️\\uD83D\\uDCA4\\uD83D\\uDC6B❌\\uD83D\\uDE21\",\n" +
            "      \"solution\": \"Hate Sleeping Alone\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"\\uD83D\\uDC49\\uD83C\\uDF88\\uD83D\\uDCA5\",\n" +
            "      \"solution\": \"Pop That\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"↪️\\uD83D\\uDC4F\\uD83D\\uDC4F\\uD83D\\uDC4F\\uD83D\\uDC4F↩️\",\n" +
            "      \"solution\": \"Round of Applause\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    return Json.parse(PuzzleEntity.serializer(), result)
}