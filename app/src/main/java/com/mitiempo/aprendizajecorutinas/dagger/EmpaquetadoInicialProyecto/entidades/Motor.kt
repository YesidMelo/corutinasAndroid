package com.mitiempo.aprendizajecorutinas.dagger.EmpaquetadoInicialProyecto.entidades

class Motor (private val tipoMotor : String) : BaseModel {

    fun getTipoMotor() : String{
        return tipoMotor
    }
}