package com.alexvolkov.test.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TileRow(
    tileModel: TileModel,
    tileEventsHandler: TileEventsHandler
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { tileEventsHandler.onTileOpen(tileModel.id) }
    ) {
        Text(text = tileModel.title)
        Text(text = tileModel.description)
    }
}

data class TileModel(
    val id: String,
    val title: String,
    val description: String,
) {
    companion object {
        val EMPTY = TileModel("", "", "")
    }
}

interface TileEventsHandler {
    fun onTileOpen(tileId: String)
    fun onTileMoreClick()
}