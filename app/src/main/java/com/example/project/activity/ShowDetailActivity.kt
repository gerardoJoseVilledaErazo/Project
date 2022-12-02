package com.example.project.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.example.project.databinding.ActivityShowDetailBinding
import com.example.project.databinding.ViewholderPopularBinding
import com.example.project.domain.FoodDomain
import com.example.project.helper.ManagementCart

class ShowDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private lateinit var objectFoodDomain: FoodDomain
    }

    private var numberOrder: Int = 1;
    private lateinit var managementCart: ManagementCart

    // Variable para manejar el viewBinding
    private lateinit var binding: ActivityShowDetailBinding
    private lateinit var binding2: ViewholderPopularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_show_detail)
        //Configuracion de ViewBinding
        binding = ActivityShowDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Show Detail"

        managementCart = ManagementCart(this)
        initView()
        getBundle()
    }

    @SuppressLint("SetTextI18n")
    private fun getBundle() {
        objectFoodDomain = intent.getSerializableExtra("object") as FoodDomain
        val drawableResourceId: Int =
            this.resources.getIdentifier(objectFoodDomain.getPic(), "drawable", this.packageName)
        Glide.with(this)
            .load(drawableResourceId)
            .into(binding2.pic)

        binding.titleTxt.text = objectFoodDomain.getTitle()
//        binding.priceTxt.text = "$" + objectFoodDomain.getFee()
        binding2.fee.text = "$" + objectFoodDomain.getFee()
        binding.descriptionTxt.text = objectFoodDomain.getDescription()
        binding.numberOrderTxt.text = numberOrder.toString()
    }

    private fun initView() {
        binding.addToCartBtn.setOnClickListener(this)
        binding.plusBtn.setOnClickListener(this)
        binding.minusBtn.setOnClickListener(this)
    }

    // Se configura la flecha para salir de la actividad
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.addToCartBtn.id -> {
                objectFoodDomain.setNumberInCart(numberOrder)
                managementCart.insertFood(objectFoodDomain)
            }
            binding.plusBtn.id -> {
                numberOrder += 1
                binding.numberOrderTxt.text = numberOrder.toString()
            }
            binding.minusBtn.id -> {
                if (numberOrder > 1) {
                    numberOrder -= 1
                }
                binding.numberOrderTxt.text = numberOrder.toString()
            }
        }
    }
}