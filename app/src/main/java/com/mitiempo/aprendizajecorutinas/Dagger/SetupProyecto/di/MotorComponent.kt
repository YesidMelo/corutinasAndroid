package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui.SetUpActivity2
import dagger.Component

@Component(modules = arrayOf(MotorModule::class))
interface MotorComponent {

    fun inject(setupActivity2: SetUpActivity2)
}