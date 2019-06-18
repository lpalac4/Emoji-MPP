package com.rightpoint.repository.models

import kotlinx.serialization.Serializable

@Serializable
data class PuzzleEntity(val emojiPuzzles: List<Puzzle>) {

    @Serializable
    data class Puzzle(val message: String, val solution: String)
}