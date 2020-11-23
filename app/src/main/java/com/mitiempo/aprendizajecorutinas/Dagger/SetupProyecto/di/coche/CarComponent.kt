package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor.MotorComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor.MotorModule
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui.SetupActivity
import dagger.Component

@Component(
        modules = [CarModule::class],
        dependencies = [MotorComponent::class]
)
interface CarComponent {
    fun inject(setupActivity: SetupActivity)
}