package com.example.project

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityCartListBinding
import com.example.project.databinding.ActivityShowDetailBinding
import com.example.project.helper.ManagementCart

class CartListActivity : AppCompatActivity() {

    //    private lateinit var adapter: RecyclerView.Adapter
    //    private lateinit var adapter: CartListAdapter
    private lateinit var managementCart: ManagementCart
    private var linearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private var tax: Double = 0.0
    private lateinit var scrollView: ScrollView

    // Variable para manejar el viewBinding
    private lateinit var binding: ActivityCartListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cart_list)
        //Configuracion de ViewBinding
        binding = ActivityCartListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Cart List"

        managementCart = ManagementCart(this)
    }

    private fun initList() {
        binding.recyclerViewList.layoutManager = linearLayoutManager
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
}