package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.cocheSubComponent

import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.ui.SetUpActivity3
import dagger.Subcomponent

@Subcomponent(modules = [CarModule::class])
interface CocheSubComponent {

    fun inject(setUpActivity3: SetUpActivity3)
}