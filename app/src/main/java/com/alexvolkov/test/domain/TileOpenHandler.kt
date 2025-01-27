package com.alexvolkov.test.domain

import kotlin.random.Random

class TileOpenHandler {

    fun canOpenTile(tileId: String): Boolean {
        return Random.nextBoolean()
    }
}