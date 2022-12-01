package com.example.project.domain

data class CategoryDomain(private var title: String, private var pic: String) {
    fun getTitle(): String = this.title
    fun getPic(): String = this.pic
}