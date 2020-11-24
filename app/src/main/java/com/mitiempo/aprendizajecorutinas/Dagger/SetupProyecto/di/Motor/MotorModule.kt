package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.Motor

import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MotorModule {

    @Named("MotorElectric")
    @Provides
    fun provideMotorElectric() : Motor = Motor("Electric")

    @Named("MotorDiesel")
    @Provides
    fun provideMotorDiesel() : Motor = Motor("Diesel")

    @Named("MotorGasoline")
    @Provides
    fun provideMotorGasoline() : Motor = Motor("Gasoline")


}