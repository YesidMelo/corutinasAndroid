package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di

import android.app.Application

class BaseApplicationSetupDagger : Application() {

    lateinit var motorComponent: MotorComponent

    override fun onCreate() {
        super.onCreate()
        motorComponent = DaggerMotorComponent
            .builder()
            .build()
    }

    fun traerMotorComponent() : MotorComponent{
        return motorComponent
    }
}