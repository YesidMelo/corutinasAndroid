package com.mitiempo.aprendizajecorutinas.Dagger.external.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.aprendizajecorutinas.Dagger.entidades.Coche
import com.mitiempo.aprendizajecorutinas.Dagger.entidades.Motor
import com.mitiempo.aprendizajecorutinas.Dagger.external.app.BaseApp
import com.mitiempo.aprendizajecorutinas.R
import javax.inject.Inject

class MainActivityDagger : AppCompatActivity() {

    fun String.imprimeEnConsola(){
        Log.e("Mensaje",this);
    }

    @Inject
    lateinit var motorDiesel : Motor

    @Inject
    lateinit var coche: Coche

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dagger)

        ejecutarInjecciones()

        "El motor creado es : ${motorDiesel.getTipoMotor()}".imprimeEnConsola()
        /*
         Este coche se creo por que existe un motor creado con anterioridad por ello se captura este motor y se inyecta en dagger
         */
        "El coche creado es : ${coche.getCoche()}".imprimeEnConsola()


    }

    private fun ejecutarInjecciones(){
        ( application as? BaseApp)?.getMotorComponent()?.inject(this)
    }
}