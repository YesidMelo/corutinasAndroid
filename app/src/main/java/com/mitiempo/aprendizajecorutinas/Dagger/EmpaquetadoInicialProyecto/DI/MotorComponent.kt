package com.mitiempo.aprendizajecorutinas.Dagger.EmpaquetadoInicialProyecto.DI

import com.mitiempo.aprendizajecorutinas.Dagger.EmpaquetadoInicialProyecto.external.Activities.MainActivityDagger
import dagger.Component
import javax.inject.Singleton

@PerActivity
@Singleton
@Component(modules = arrayOf(MotorModule::class))
interface MotorComponent {
    fun inject(mainActivityDagger: MainActivityDagger)
}