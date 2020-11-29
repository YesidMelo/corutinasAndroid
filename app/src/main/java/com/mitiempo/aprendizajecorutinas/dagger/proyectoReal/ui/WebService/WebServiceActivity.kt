package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.WebService

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mitiempo.aprendizajecorutinas.R
import com.mitiempo.aprendizajecorutinas.databinding.ActivityWebServiceBinding

class WebServiceActivity : AppCompatActivity() {

    lateinit var binding : ActivityWebServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()

    }



    private fun setUpListeners() {
        binding.buttonHacerPeticionWeb.setOnClickListener {  }
        binding.buttonVolverProfile.setOnClickListener {  }
    }



}