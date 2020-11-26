package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di

import android.app.Application
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor.DaggerMotorComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor.MotorComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche.CarComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche.CarModule
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche.DaggerCarComponent
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.cocheSubComponent.CocheSubComponent

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