package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Car
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CarModule {

    @Provides
    fun car(motor: Motor) : Car{
        return Car(motor)
    }

    @Named("electric_car")
    @Provides
    fun carElectric(@Named("MotorElectric") motor: Motor) : Car{
        return Car(motor)
    }
    @Named("diesel_car")
    @Provides
    fun carDiesel(@Named("MotorDiesel") motor: Motor) : Car{
        return Car(motor)
    }
    @Named("gasoline_car")
    @Provides
    fun carGasoline(@Named("MotorGasoline") motor: Motor) : Car{
        return Car(motor)
    }
}