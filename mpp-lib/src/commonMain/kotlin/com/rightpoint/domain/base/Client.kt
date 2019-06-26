package com.rightpoint.domain

import com.rightpoint.domain.base.IView
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class Client(private val mainContext: CoroutineContext, private val baseView: IView) : CoroutineScope {

    private val job = Job()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        baseView.showError(throwable)
    }

    override val coroutineContext: CoroutineContext
    get() = mainContext + job + exceptionHandler

    open fun onDestroy() {
        job.cancel()
    }
}