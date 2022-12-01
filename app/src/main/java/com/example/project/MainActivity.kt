package com.example.project

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapter.CategoryAdapter
import com.example.project.adapter.PopularAdapter
import com.example.project.databinding.ActivityMainBinding
import com.example.project.domain.CategoryDomain
import com.example.project.domain.FoodDomain
import com.example.project.domain.`interface`.IOnClickListener

class MainActivity : AppCompatActivity()/*, IOnClickListener */ {

    private lateinit var adapter: CategoryAdapter
    private lateinit var adapter2: PopularAdapter
    private var linearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    // Variable para manejar el viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //Configuracion de ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        recyclerViewCategory()
        recyclerViewPopular()
    }

    private fun recyclerViewCategory() {
        val category: ArrayList<CategoryDomain> = ArrayList()
        category.add(CategoryDomain("Pizza", "cat_1"))
        category.add(CategoryDomain("Burger", "cat_2"))
        category.add(CategoryDomain("Hotdog", "cat_3"))
        category.add(CategoryDomain("Drink", "cat_4"))
        category.add(CategoryDomain("Donut", "cat_5"))
        adapter = CategoryAdapter(lstCategorias = category, this)
        binding.recyclerViewCategoryList.setHasFixedSize(true)
        binding.recyclerViewCategoryList.layoutManager = linearLayoutManager
        binding.recyclerViewCategoryList.adapter = adapter
    }

    private fun recyclerViewPopular() {
        val linearLayoutManager2: LinearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val foodList: ArrayList<FoodDomain> = ArrayList()
        foodList.add(
            FoodDomain(
                "Pepperoni pizza",
                "pizza1",
                "slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",
                8.00
            )
        )
        foodList.add(
            FoodDomain(
                "Cheese Burger",
                "burger",
                "Beef, Gouda Cheese, Special Sauce, Lettuce, Tomato",
                7.00
            )
        )
        foodList.add(
            FoodDomain(
                "Vegetable pizza",
                "pizza3",
                "Olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil",
                8.00
            )
        )


        adapter2 = PopularAdapter(lstPopularFood = foodList, this)

        binding.recyclerViewPopularList.setHasFixedSize(true)

        binding.recyclerViewPopularList.layoutManager = linearLayoutManager2

        binding.recyclerViewPopularList.adapter = adapter2
    }

//    override fun onClickListener(categoryDomain: CategoryDomain, position: Int) {
//    }
}