package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di

import android.app.Application
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.Motor.DaggerMotorComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.Motor.MotorComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche.CarComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.coche.DaggerCarComponent
import com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto.di.cocheSubComponent.CocheSubComponent

class BaseApplicationSetupDagger : Application() {

    lateinit var motorComponent: MotorComponent
    lateinit var carComponent : CarComponent
    lateinit var cocheSubComponent: CocheSubComponent

    override fun onCreate() {
        super.onCreate()

        motorComponent = DaggerMotorComponent
            .builder()
            .build()

        carComponent = DaggerCarComponent
            .builder()
            .motorComponent(motorComponent) // componente padre
            .build()

        //Subcomponente
        cocheSubComponent = motorComponent
                .plusCocheSubComponent(CarModule())


    }

    fun traerMotorComponent() : MotorComponent {
        return motorComponent
    }

    fun traerCarComponent() : CarComponent{
        return carComponent
    }

    fun plusCocheSubComponent() : CocheSubComponent{
        return cocheSubComponent
    }
}