package com.example.project.adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.activity.ShowDetailActivity
import com.example.project.databinding.ViewholderPopularBinding
import com.example.project.domain.FoodDomain

class PopularAdapter(
    private val lstPopularFood: MutableList<FoodDomain> = ArrayList(), var context: Context
) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layout = LayoutInflater.from(parent.context)
        return ViewHolder(
            layout.inflate(
                R.layout.viewholder_popular,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstPopularFood[position]

        with(holder) {
            binding.title2.text = item.getTitle()
            binding.fee.text = item.getFee().toString()
//            val picUrl: String = item.getPic()
//            when (picUrl) {
//                "cat_1" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background1)
//
//                "cat_2" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background2)
//
//                "cat_3" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background3)
//
//                "cat_4" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background4)
//
//                "cat_5" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background5)
//            }
            val drawableResourceId: Int = holder.itemView.context.resources.getIdentifier(
                lstPopularFood[position].getPic(),
                "drawable",
                holder.itemView.context.packageName
            )
            Glide.with(holder.itemView.context).load(drawableResourceId)
//                .diskCacheStrategy(
//                DiskCacheStrategy.ALL
//            ).centerCrop().circleCrop()
                .into(binding.pic)

            holder.binding.addBtn.setOnClickListener {
                val intent = Intent(holder.itemView.context, ShowDetailActivity::class.java)
                intent.putExtra("object", lstPopularFood[position])
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    fun updateState(position: Int) {
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int = lstPopularFood.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewholderPopularBinding.bind(view)
    }
}