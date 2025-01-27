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
fun CategoriesRow(
    categoryModel: CategoryModel,
    categoryEventsHandler: CategoryEventsHandler
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { categoryEventsHandler.onCategoryOpen(categoryModel.id) }
    ) {
        Text(text = categoryModel.title)
        Text(text = categoryModel.description)
    }
}

data class CategoryModel(
    val id: String,
    val title: String,
    val description: String,
) {
    companion object {
        val EMPTY = CategoryModel("", "", "")
    }
}

interface CategoryEventsHandler {
    fun onCategoryOpen(categoryId: String)
}