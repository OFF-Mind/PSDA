package com.alexvolkov.test.samplescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.alexvolkov.test.samplescreen.presentation.SampleScreenState
import com.alexvolkov.test.samplescreen.presentation.SampleViewModel
import com.alexvolkov.test.samplescreen.presentation.SampleViewModelEvents
import com.alexvolkov.test.samplescreen.presentation.SampleViewModelHandler
import com.alexvolkov.test.ui.ObserveAsEvents
import com.alexvolkov.test.ui.components.CategoriesRow
import com.alexvolkov.test.ui.components.TileRow

@Composable
fun SampleScreen(
    viewModel: SampleViewModel,
    vmEvents: (event: SampleViewModelEvents) -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()

    ObserveAsEvents(viewModel.uiEventChanelFlow) { event ->
        vmEvents.invoke(event)
    }

    SampleScreenContent(uiState.value, viewModel)
}

@Composable
private fun SampleScreenContent(
    state: SampleScreenState,
    eventsHandler: SampleViewModelHandler
) {
    TileRow(state.tileData, eventsHandler)
    CategoriesRow(state.categoryData, eventsHandler)
}
