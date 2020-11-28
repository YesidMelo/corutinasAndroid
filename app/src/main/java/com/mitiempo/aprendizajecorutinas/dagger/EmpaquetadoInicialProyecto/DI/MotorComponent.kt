package com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.DI

import com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.external.Activities.MainActivityDagger
import dagger.Component
import javax.inject.Singleton

@PerActivity
@Singleton
@Component(modules = arrayOf(MotorModule::class))
interface MotorComponent {
    fun inject(mainActivityDagger: MainActivityDagger)
}