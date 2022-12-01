package com.example.project.domain.`interface`

import com.example.project.domain.CategoryDomain

interface IOnClickListener {
    fun onClickListener(categoryDomain: CategoryDomain, position: Int)
}