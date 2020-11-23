package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.coche

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Car
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import dagger.Module
import dagger.Provides

@Module
class CarModule {

    @Provides
    fun carElectric(motor: Motor) : Car{
        return Car(motor)
    }
}