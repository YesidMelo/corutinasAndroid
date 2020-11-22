package com.mitiempo.aprendizajecorutinas.Dagger.external.app

import android.app.Application
import android.util.Log
import com.mitiempo.aprendizajecorutinas.Dagger.DI.DaggerMotorComponent
import com.mitiempo.aprendizajecorutinas.Dagger.DI.MotorComponent

/**
 * Esta clase construye todos los modulos al principio (En tiempo de ejecucion)
 */
class BaseApp : Application() {

    fun String.imprimerEnConsola(){
        Log.e("Mensaje",this);
    }

    private lateinit var motorComponent: MotorComponent

    override fun onCreate() {
        super.onCreate()
        "estoy entrando a BaseApp".imprimerEnConsola()

        motorComponent = DaggerMotorComponent
            .builder()
            .build()
    }

    fun getMotorComponent() : MotorComponent{
        return motorComponent
    }
}