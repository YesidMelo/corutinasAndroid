package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche

import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.Motor.MotorComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.ui.SetupActivity
import dagger.Component

@Component(
        modules = [CarModule::class],
        dependencies = [MotorComponent::class]
)
interface CarComponent {
    fun inject(setupActivity: SetupActivity)
}