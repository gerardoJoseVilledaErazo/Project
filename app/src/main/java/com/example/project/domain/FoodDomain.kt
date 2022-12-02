package com.example.project.domain

data class FoodDomain(
    private var title: String,
    private var pic: String,
    private var description: String,
    private var fee: Double,
    private var numberInCart: Int
) {
    constructor(
        title: String,
        pic: String,
        description: String,
        fee: Double
//        numberInCart: Int
    ) : this(title, pic, description, fee, 0)

    fun getTitle(): String = this.title
    fun getPic(): String = this.pic
    fun getDescription(): String = this.description
    fun getFee(): Double = this.fee
    fun getNumberInCart(): Int = this.numberInCart

    fun setNumberInCart(numberInCart: Int) {
        this.numberInCart = numberInCart
    }


}