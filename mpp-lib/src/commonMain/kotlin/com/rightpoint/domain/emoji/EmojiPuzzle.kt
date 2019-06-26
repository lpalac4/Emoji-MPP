package com.rightpoint.domain.emoji

import com.rightpoint.repository.models.PuzzleEntity

expect fun createRandomInt(vararg max: Int): Int

data class EmojiPuzzle(val entity: PuzzleEntity) {

    var currentEmoji: PuzzleEntity.Puzzle? = null

    init {
        pickNewEmoji()
    }

    fun pickNewEmoji() {
        if(entity.emojiPuzzles.isEmpty()) {
            return
        }

        currentEmoji = entity.emojiPuzzles[createRandomInt(entity.emojiPuzzles.size)]
    }

    fun compareWithCurrentEmoji(text: CharSequence): Boolean {
        return currentEmoji?.solution?.equals(text.toString(), true) ?: false
    }
}