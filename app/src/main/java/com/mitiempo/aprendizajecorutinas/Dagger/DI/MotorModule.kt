package com.mitiempo.aprendizajecorutinas.Dagger.DI

import com.mitiempo.aprendizajecorutinas.Dagger.entidades.Motor
import dagger.Module
import dagger.Provides

@Module
class MotorModule {

    @Provides
    fun provideMotorDiesel() : Motor {
        return Motor("Diesel")
    }

}