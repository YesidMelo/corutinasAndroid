package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui.SetUpActivity2
import dagger.Component

@Component(modules = [MotorModule::class])
interface MotorComponent {

    fun inject(setUpActivity2: SetUpActivity2)
    fun motor() : Motor
}