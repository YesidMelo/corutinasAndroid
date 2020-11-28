package com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.DI

import com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.entidades.Coche
import com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.entidades.Motor
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MotorModule {

    @Singleton
    @Named("Diesel")
    @Provides
    fun provideMotorDiesel() : Motor {
        return Motor("Diesel")
    }

    @Singleton
    @Named("Gasolina")
    @Provides
    fun provideMotorGasolina() : Motor{
        return Motor("Gasolina")
    }

    @Provides
    fun provideCoche(@Named("Gasolina") motor: Motor) : Coche{
        return Coche(motor)
    }



}