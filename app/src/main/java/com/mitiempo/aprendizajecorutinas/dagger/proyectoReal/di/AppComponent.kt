package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.di

import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Login.LoginActivity
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile.ProfileActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(profileActivity: ProfileActivity)
}