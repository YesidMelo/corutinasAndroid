package com.mitiempo.aprendizajecorutinas.Dagger.external.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.aprendizajecorutinas.Dagger.entidades.Coche
import com.mitiempo.aprendizajecorutinas.Dagger.entidades.Motor
import com.mitiempo.aprendizajecorutinas.Dagger.external.app.BaseApp
import com.mitiempo.aprendizajecorutinas.R
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Named

class MainActivityDagger : AppCompatActivity() {

    fun String.imprimeEnConsola(){
        Log.e("Mensaje",this);
    }

    @Inject
    @Named("Diesel")
    lateinit var motorDiesel : Motor

    @Inject
    lateinit var coche: Coche

    @Inject
    lateinit var cocheLazy : Lazy<Coche> // si es muy pesada la carga de un objeto este puede usar la etiqueta Lazy de dagger. la cual lo carga unicamente cuando es necesario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dagger)

        ejecutarInjecciones()

        "El motor creado es : ${motorDiesel.getTipoMotor()}".imprimeEnConsola()
        /*
         Este coche se creo por que existe un motor creado con anterioridad por ello se captura este motor y se inyecta en dagger
         */
        "El coche creado es : ${coche.getCoche()}".imprimeEnConsola()
        "El cocheLazy creado es : ${cocheLazy.get().getCoche()}".imprimeEnConsola()


    }

    private fun ejecutarInjecciones(){
        ( application as? BaseApp)?.getMotorComponent()?.inject(this)
    }
}