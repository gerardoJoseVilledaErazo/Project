package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.project.R
import com.example.project.domain.CategoryDomain
import com.example.project.databinding.ViewholderCategoryBinding
import com.example.project.domain.`interface`.IOnClickListener

class CategoryAdapter(
    private val lstCategorias: MutableList<CategoryDomain> = ArrayList(), var context: Context
    //private val listener: IOnClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

//    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layout = LayoutInflater.from(parent.context)
        return ViewHolder(
            layout.inflate(
                R.layout.viewholder_category,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstCategorias[position]


//        holder.bind(item, context, position)


//        with(holder) {
//            val categoryDomain: CategoryDomain = item as CategoryDomain
//            setListener(categoryDomain, position)
//            binding.categoryName.text = categoryDomain.getTitle()
//            val picUrl: String = ""
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
//            val drawableResourceId: Int = holder.itemView.context.resources.getIdentifier(
//                picUrl,
//                "drawable",
//                holder.itemView.context.packageName
//            )
//            Glide.with(holder.itemView.context).load(drawableResourceId).diskCacheStrategy(
//                DiskCacheStrategy.ALL
//            ).centerCrop().circleCrop().into(binding.categoryPic)
//        }


        with(holder) {
//            val categoryDomain: CategoryDomain = item as CategoryDomain
            binding.categoryName.text = item.getTitle()
//            val pic:String = item.getPic()

//            val picUrl: String = ""
            val picUrl: String = item.getPic()
            when (picUrl) {
                "cat_1" -> binding.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background1)

                "cat_2" -> binding.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background2)

                "cat_3" -> binding.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background3)

                "cat_4" -> binding.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background4)

                "cat_5" -> binding.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_background5)
            }
            val drawableResourceId: Int = holder.itemView.context.resources.getIdentifier(
                picUrl,
                "drawable",
                holder.itemView.context.packageName
            )
            Glide.with(holder.itemView.context).load(drawableResourceId)
//                .diskCacheStrategy(
//                DiskCacheStrategy.ALL
//            ).centerCrop().circleCrop()
                .into(binding.categoryPic)
        }
    }

    fun updateState(position: Int) {
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int = lstCategorias.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewholderCategoryBinding.bind(view)

//        fun bind(categoryDomain: CategoryDomain, context: Context, position: Int) {
////            val categoryDomain: CategoryDomain = CategoryDomain()
//            binding.categoryName.text = categoryDomain.getTitle()
//            val picUrl: String = ""
//            when (picUrl) {
//                "cat_1" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(itemView.context, R.drawable.cat_background1)
//
//                "cat_2" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(itemView.context, R.drawable.cat_background2)
//
//                "cat_3" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(itemView.context, R.drawable.cat_background3)
//
//                "cat_4" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(itemView.context, R.drawable.cat_background4)
//
//                "cat_5" -> binding.mainLayout.background =
//                    ContextCompat.getDrawable(itemView.context, R.drawable.cat_background5)
//            }
//            val drawableResourceId: Int = itemView.context.resources.getIdentifier(
//                picUrl,
//                "drawable",
//                itemView.context.packageName
//            )
//            Glide.with(itemView.context).load(drawableResourceId).diskCacheStrategy(
//                DiskCacheStrategy.ALL
//            ).centerCrop().circleCrop().into(binding.categoryPic)
//        }

//        fun setListener(categoryDomain: CategoryDomain, position: Int) {
//            binding.root.setOnClickListener {
//                listener.onClickListener(categoryDomain, position)
//            }
//        }
    }
}