package com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.external.app

import android.app.Application
import android.util.Log
import com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.DI.DaggerMotorComponent
import com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.DI.MotorComponent

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