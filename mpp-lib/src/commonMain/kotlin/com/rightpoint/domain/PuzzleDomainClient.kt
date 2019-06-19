package com.rightpoint.domain

import com.rightpoint.domain.models.EmojiPuzzle
import com.rightpoint.repository.IRepositoryClient
import com.rightpoint.repository.PuzzleRepositoryClient

class PuzzleDomainClient {
//    override val repository: IRepositoryClient
//        get() = PuzzleRepositoryClient()
//
//    override suspend fun getPuzzles(): EmojiPuzzle {
//        return EmojiPuzzle(repository.retrieveEmojiData())
//    }

    val repository: IRepositoryClient
        get() = PuzzleRepositoryClient()

    suspend fun getPuzzles(): EmojiPuzzle {
        return EmojiPuzzle(repository.retrieveEmojiData())
    }
}