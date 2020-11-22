package com.mitiempo.aprendizajecorutinas.Dagger.entidades

class Coche(private val motor: Motor) : BaseModel {

    fun getCoche() : String{
        return "Coche con motor ${motor.getTipoMotor()}"
    }
}