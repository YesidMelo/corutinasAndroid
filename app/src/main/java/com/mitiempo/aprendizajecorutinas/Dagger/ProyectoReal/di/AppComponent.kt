package com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.di

import com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.ui.Login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)
}