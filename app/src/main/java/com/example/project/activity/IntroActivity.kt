package com.example.project.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity(), View.OnClickListener {

    // Variable para manejar el viewBinding
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intro)
        //Configuracion de ViewBinding
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Configurar evento click de los botones
        binding.startBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.startBtn.id -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}