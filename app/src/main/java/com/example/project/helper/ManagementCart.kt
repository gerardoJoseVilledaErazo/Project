package com.example.project.helper

import android.content.Context
import android.widget.Toast
import com.example.project.Interface.ChangeNumberItemsListener
import com.example.project.domain.FoodDomain

class ManagementCart {
    private lateinit var context: Context
    private lateinit var tinyDB: TinyDB

    constructor(context: Context) {
        this.context = context
        this.tinyDB = TinyDB(context)
    }

    fun insertFood(item: FoodDomain) {
        val listFood: ArrayList<FoodDomain> = getListCart()
        var existAlready: Boolean = false
        var n: Int = 0
        for (i in listFood.indices) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true
                n = i
                break
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart())
        } else {
            listFood.add(item)
        }
        tinyDB.putListObject("CardList", listFood)
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show()
    }

    fun getListCart(): ArrayList<FoodDomain> {
        return tinyDB.getListObject("CarList")
    }

    fun plusNumberFood(
        listFood: ArrayList<FoodDomain>,
        position: Int,
        changeNumberItemsListener: ChangeNumberItemsListener
    ) {
        listFood[position].setNumberInCart(listFood[position].getNumberInCart() + 1)
        tinyDB.putListObject("CartList", listFood)
        changeNumberItemsListener.changed()
    }

    fun minusNumberFood(
        listFood: ArrayList<FoodDomain>,
        position: Int,
        changeNumberItemsListener: ChangeNumberItemsListener
    ) {
        if (listFood[position].getNumberInCart() == 1) {
            listFood.removeAt(position)
        } else {
            listFood[position].setNumberInCart(listFood[position].getNumberInCart() - 1)
        }
        tinyDB.putListObject("CartList", listFood)
        changeNumberItemsListener.changed()
    }

    fun getTotalFee(): Double {
        val listFood: ArrayList<FoodDomain> = getListCart()
        var fee: Double = 0.0
    }
}