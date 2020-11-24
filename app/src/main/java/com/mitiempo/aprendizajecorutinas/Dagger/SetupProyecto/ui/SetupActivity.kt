package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Car
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.BaseApplicationSetupDagger
import com.mitiempo.aprendizajecorutinas.R
import javax.inject.Inject
import javax.inject.Named


class SetupActivity : AppCompatActivity() {

    fun String.imprimirEnConsola(){
        Log.e("Mensaje",this)
    }

    lateinit  var boton1 : Button
    lateinit  var boton2 : Button


    @Named("diesel_car")
    @Inject
    lateinit var carElectric : Car



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        buscarElementosDeVista()
        ponerEscuchadores()
        startInjections()

        "el coche fabricador es : ${carElectric.getCar()}".imprimirEnConsola()
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

    private fun startInjections() {
        (application as BaseApplicationSetupDagger).carComponent.inject(this)
    }
}