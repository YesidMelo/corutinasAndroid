package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.di

import android.app.Application

class BaseAppLogin : Application() {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        setUpGraph()
    }

    private fun setUpGraph(){
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getMyAppComponent() : AppComponent{
        return appComponent
    }

}