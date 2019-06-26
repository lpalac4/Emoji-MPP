package com.rightpoint.repository

import com.rightpoint.repository.models.PuzzleEntity
import kotlin.reflect.KClass

expect fun parseFileToPuzzleEntity(kClass: KClass<PuzzleEntity>, fileName: String): PuzzleEntity

class PuzzleRepositoryClient: IRepositoryClient {

    override suspend fun retrieveEmojiData(): PuzzleEntity {

        val obj = parseFileToPuzzleEntity(PuzzleEntity::class, "emojipuzzles.json")
        return obj
    }
}


//BELOW is common implementation to parse a string
// Json also has .Default configuration which provides more reasonable settings,
// but is subject to change in future versions
//        val json = Json(JsonConfiguration.Stable)

//        // serializing objects
//        val jsonData = json.stringify(PuzzleEntity.serializer(), PuzzleEntity())
//        // serializing lists
//        val jsonList = json.stringify(PuzzleEntity.serializer().list, listOf(PuzzleEntity.Puzzle()))

// parsing data back
//        val obj = json.parse(PuzzleEntity.serializer(), "{\n" +
//                "  \"emojiPuzzles\": [\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83D\\uDD25\\uD83D\\uDCF2\\uD83D\\uDC8D\\uD83D\\uDC8E\",\n" +
//                "      \"solution\": \"Hotline Bling\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83C\\uDF2C️\\uD83C\\uDF2C️\\uD83D\\uDCB5\\uD83D\\uDCB5\\uD83D\\uDCB8\",\n" +
//                "      \"solution\": \"Money to Blow\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83D\\uDCAA\\uD83C\\uDFFD1️⃣\\uD83C\\uDFC5\\uD83D\\uDCAF\",\n" +
//                "      \"solution\": \"Champion\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83D\\uDD2A\\uD83C\\uDF4D\\uD83C\\uDF4D\\uD83D\\uDDE1️\",\n" +
//                "      \"solution\": \"Diced Pineapples\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83D\\uDECF️\\uD83D\\uDCA4\\uD83D\\uDC6B❌\\uD83D\\uDE21\",\n" +
//                "      \"solution\": \"Hate Sleeping Alone\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"\\uD83D\\uDC49\\uD83C\\uDF88\\uD83D\\uDCA5\",\n" +
//                "      \"solution\": \"Pop That\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"message\": \"↪️\\uD83D\\uDC4F\\uD83D\\uDC4F\\uD83D\\uDC4F\\uD83D\\uDC4F↩️\",\n" +
//                "      \"solution\": \"Round of Applause\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}")