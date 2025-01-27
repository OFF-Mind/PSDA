package com.alexvolkov.test.samplescreen.presentation

import com.alexvolkov.test.ui.components.CategoryModel
import com.alexvolkov.test.ui.components.TileModel

data class SampleScreenState(
    val isLoading: Boolean,
    val isError: Boolean,
    val showMenu: Boolean,
    val tileData: TileModel,
    val categoryData: CategoryModel
) {
    companion object {
        val EMPTY = SampleScreenState(
            isLoading = false,
            isError = false,
            showMenu = false,
            tileData = TileModel.EMPTY,
            categoryData = CategoryModel.EMPTY
        )
    }
}