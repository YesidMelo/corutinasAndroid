package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mitiempo.aprendizajecorutinas.R


class SetupActivity : AppCompatActivity() {
    lateinit  var boton1 : Button
    lateinit  var boton2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        buscarElementosDeVista()
        ponerEscuchadores()
    }

    private fun buscarElementosDeVista() {
        boton1 = findViewById(R.id.button_segunda_activity)
        boton2 = findViewById(R.id.button_tercera_actividad)
    }

    private fun ponerEscuchadores(){
        boton1.setOnClickListener {
            startActivity(Intent(this, SetUpActivity2::class.java))
        }
        boton2.setOnClickListener {
            startActivity(Intent(this, SetUpActivity3::class.java))
        }
    }
}