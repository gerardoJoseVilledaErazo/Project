package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Interface.ChangeNumberItemsListener
import com.example.project.R
import com.example.project.databinding.ViewholderCartBinding
import com.example.project.databinding.ViewholderCategoryBinding
import com.example.project.domain.CategoryDomain
import com.example.project.domain.FoodDomain
import com.example.project.helper.ManagementCart

class CartListAdapter(
    private val lstFoodDomains: MutableList<FoodDomain> = ArrayList(),
    private var managementCart: ManagementCart,
    private var changeNumberItemsListener: ChangeNumberItemsListener,
    var context: Context
) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

//    private lateinit var managementCart: ManagementCart
//    private lateinit var changeNumberItemsListener: ChangeNumberItemsListener

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewholderCartBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layout = LayoutInflater.from(parent.context)
        return ViewHolder(
            layout.inflate(
                R.layout.viewholder_cart,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = lstFoodDomains.size
}