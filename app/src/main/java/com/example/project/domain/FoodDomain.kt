package com.example.project.domain

import java.io.Serializable

data class FoodDomain(
    private var title: String,
    private var pic: String,
    private var description: String,
    private var fee: Double,
    private var numberInCart: Int
) : Serializable {
    constructor(
        title: String,
        pic: String,
        description: String,
        fee: Double
//        numberInCart: Int
    ) : this(title, pic, description, fee, 0)

//    constructor(
//        title: String,
//        pic: String,
//        description: String,
//        fee: Double,
//        numberInCart: Int
//    ) : this(title, pic, description, fee, numberInCart){}

    fun getTitle(): String = this.title
    fun getPic(): String = this.pic
    fun getDescription(): String = this.description
    fun getFee(): Double = this.fee
    fun getNumberInCart(): Int = this.numberInCart

    fun setTitle(title: String) {
        this.title = title
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun setFee(fee: Double) {
        this.fee = fee
    }

    fun setNumberInCart(numberInCart: Int) {
        this.numberInCart = numberInCart
    }
}