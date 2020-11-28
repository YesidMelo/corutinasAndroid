package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.Motor

import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.Motor
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.cocheSubComponent.CocheSubComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.ui.SetUpActivity2
import dagger.Component
import javax.inject.Named

@Component(modules = [MotorModule::class])
interface MotorComponent {

    fun inject(setUpActivity2: SetUpActivity2)
    @Named("MotorGasoline") fun motor() : Motor
    @Named("MotorGasoline") fun motorGasoline() : Motor
    @Named("MotorElectric") fun motorElectric() : Motor
    @Named("MotorDiesel") fun motorDiesel() : Motor

    //Subcomponente con coche subComponent
    fun plusCocheSubComponent(carModule: CarModule) : CocheSubComponent
}