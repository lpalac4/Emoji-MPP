package com.rightpoint.domain

import com.rightpoint.domain.emoji.EmojiPuzzle
import com.rightpoint.repository.IRepositoryClient
import com.rightpoint.repository.PuzzleRepositoryClient
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PuzzlePresenter(mainThread: CoroutineContext,
                      private val view: IEmojiPuzzleView): Client(mainThread, view) {

    private val repository: IRepositoryClient = PuzzleRepositoryClient()

    fun getPuzzles() {
        launch(coroutineContext) {
            view.onEmojiSuccess(EmojiPuzzle(repository.retrieveEmojiData()))
        }
    }
}
