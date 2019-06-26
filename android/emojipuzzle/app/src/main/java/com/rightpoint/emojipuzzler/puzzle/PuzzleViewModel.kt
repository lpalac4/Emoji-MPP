package com.rightpoint.emojipuzzler.puzzle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rightpoint.domain.IEmojiPuzzleView
import com.rightpoint.domain.PuzzlePresenter
import com.rightpoint.domain.emoji.EmojiPuzzle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class PuzzleViewModel: ViewModel(), IEmojiPuzzleView {

    var puzzle: EmojiPuzzle? = null

    var feedBackLiveData: MutableLiveData<String> = MutableLiveData()
    var currentEmojiPuzzle: MutableLiveData<String> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    private val viewModelJob = Job()
    private val domainScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    private var presenter = PuzzlePresenter(mainThread = domainScope.coroutineContext, view = this)

    override fun onEmojiSuccess(emojiPuzzle: EmojiPuzzle) {
        puzzle = emojiPuzzle
        currentEmojiPuzzle.postValue(puzzle?.currentEmoji?.message)
        loading.postValue(false)
    }

    fun startGame() {
        loading.value = true
        presenter.getPuzzles()
    }

    fun newEmoji() {
        puzzle?.pickNewEmoji()
        currentEmojiPuzzle.value = puzzle?.currentEmoji?.message
    }

    fun checkAnswer(text: CharSequence) {
        val solution = puzzle?.compareWithCurrentEmoji(text)
        if(solution != null && solution) {
            feedBackLiveData.value = "That's right."
        } else {
            feedBackLiveData.value = "Nope try again. Hint: They're Drake Songs."
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}