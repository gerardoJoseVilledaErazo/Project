package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.Interface.ChangeNumberItemsListener
import com.example.project.R
import com.example.project.databinding.ViewholderCartBinding
import com.example.project.databinding.ViewholderCategoryBinding
import com.example.project.domain.CategoryDomain
import com.example.project.domain.FoodDomain
import com.example.project.helper.ManagementCart
import kotlin.math.roundToInt

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
        val item = lstFoodDomains[position]

        with(holder) {
            binding.titleTxt2.text = item.getTitle()
            binding.feeEachItem.text = item.getFee().toString()
            binding.totalEachItem.text = (((item.getNumberInCart()
                .toDouble() * item.getFee()) * 100).roundToInt() / 100).toString()
            binding.numberItemTxt.text = item.getNumberInCart().toString()
            val drawableResourceId: Int = holder.itemView.context.resources.getIdentifier(
                item.getPic(),
                "drawable",
                holder.itemView.context.packageName
            )
            Glide.with(holder.itemView.context).load(drawableResourceId)
//                .diskCacheStrategy(
//                DiskCacheStrategy.ALL
//            ).centerCrop().circleCrop()
                .into(binding.picCart)

            binding.plusCartBtn.setOnClickListener {
                //
            }
        }
    }

    override fun getItemCount(): Int = lstFoodDomains.size
}