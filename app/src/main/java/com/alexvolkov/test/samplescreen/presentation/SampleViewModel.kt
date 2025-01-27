package com.alexvolkov.test.samplescreen.presentation

import androidx.lifecycle.viewModelScope
import com.alexvolkov.test.domain.TileOpenHandler
import com.alexvolkov.test.base.BaseVm
import com.alexvolkov.test.ui.components.CategoryEventsHandler
import com.alexvolkov.test.ui.components.TileEventsHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface SampleViewModelHandler : TileEventsHandler, CategoryEventsHandler

class SampleViewModel(
    private val tileOpenHandler: TileOpenHandler
) : BaseVm<SampleScreenState, SampleViewModelEvents>(SampleScreenState.EMPTY),
    SampleViewModelHandler {

    init {
        viewModelScope.launch {
            delay(1000)
            sendEvent(SampleViewModelEvents.ShowError("some error"))
        }
    }

    override fun onTileOpen(tileId: String) {
        if (tileOpenHandler.canOpenTile(tileId)) {
            sendEvent(SampleViewModelEvents.OpenVideo(tileId))
        } else {
            sendEvent(SampleViewModelEvents.ShowError(tileId))
        }
    }

    override fun onTileMoreClick() {
        updateState { it.copy(showMenu = true) }
    }

    override fun onCategoryOpen(categoryId: String) {
        // handle category open
    }
}

sealed class SampleViewModelEvents {
    data class OpenVideo(val videoId: String) : SampleViewModelEvents()
    data class ShowError(val errorId: String) : SampleViewModelEvents()
}