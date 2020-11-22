package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MotorModule {

    @Named("Diesel")
    @Provides
    fun provideMotorDiesel() : Motor{
        return Motor("Diesel")
    }

    @Named("Electric")
    @Provides
    fun provideMotorElectric() : Motor{
        return Motor("Electric")
    }

    @Named("Gasolina")
    @Provides
    fun provideMotorGasolina() : Motor{
        return Motor("Gasolina")
    }


}