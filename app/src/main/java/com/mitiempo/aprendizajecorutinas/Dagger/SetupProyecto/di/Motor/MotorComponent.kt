package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.cocheSubComponent.CocheSubComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui.SetUpActivity2
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