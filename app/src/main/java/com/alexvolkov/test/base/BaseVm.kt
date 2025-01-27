package com.alexvolkov.test.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

abstract class BaseVm<T : Any, E : Any>(initialState: T) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<T> = _uiState

    private val uiEventChanel = Channel<E>()
    val uiEventChanelFlow = uiEventChanel.receiveAsFlow()

    protected fun updateState(update: (T) -> T) = _uiState.update(update)

    protected fun sendEvent(event: E) = uiEventChanel.trySend(event)
}