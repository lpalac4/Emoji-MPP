package com.rightpoint.domain

import com.rightpoint.domain.emoji.EmojiPuzzle
import com.rightpoint.domain.base.IView

interface IEmojiPuzzleView: IView {
    override fun showError(throwable: Throwable) {

    }

    fun onEmojiSuccess(emojiPuzzle: EmojiPuzzle) {

    }
}