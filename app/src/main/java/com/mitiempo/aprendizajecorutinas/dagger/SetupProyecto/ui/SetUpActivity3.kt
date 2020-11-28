package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.Car
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.BaseApplicationSetupDagger
import com.mitiempo.aprendizajecorutinas.R
import javax.inject.Inject
import javax.inject.Named

class SetUpActivity3 : AppCompatActivity() {

    fun String.imprimeEnConsola(){
        Log.e("Mensaje",this);
    }

    @Named("electric_car")
    @Inject
    lateinit var electricCar : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up3)
        setUpInjections()
        "El coche generado fue : ${electricCar.getCar()}".imprimeEnConsola()
    }

    private fun setUpInjections(){
        (application as BaseApplicationSetupDagger).plusCocheSubComponent().inject(this)
    }
}