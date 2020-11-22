package com.mitiempo.aprendizajecorutinas.Dagger.entidades

class Motor (private val tipoMotor : String) : BaseModel {

    fun getTipoMotor() : String{
        return tipoMotor
    }
}