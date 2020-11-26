package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.cocheSubComponent

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui.SetUpActivity3
import dagger.Subcomponent

@Subcomponent(modules = [CarModule::class])
interface CocheSubComponent {

    fun inject(setUpActivity3: SetUpActivity3)
}