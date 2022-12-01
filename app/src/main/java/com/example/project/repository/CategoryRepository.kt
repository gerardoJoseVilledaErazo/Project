package com.example.project.repository

import com.example.project.domain.CategoryDomain

data class CategoryRepository(var lstCategorias: MutableList<CategoryDomain> = mutableListOf()) {
    fun add(categoryDomain: CategoryDomain) {
        lstCategorias.add(categoryDomain)
    }

    fun get(): MutableList<CategoryDomain> = lstCategorias
}