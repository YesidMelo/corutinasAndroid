package com.mitiempo.aprendizajecorutinas.Dagger.DI

import com.mitiempo.aprendizajecorutinas.Dagger.external.Activities.MainActivityDagger
import dagger.Component

@PerActivity
@Component(modules = arrayOf(MotorModule::class))
interface MotorComponent {
    fun inject(mainActivityDagger: MainActivityDagger)
}