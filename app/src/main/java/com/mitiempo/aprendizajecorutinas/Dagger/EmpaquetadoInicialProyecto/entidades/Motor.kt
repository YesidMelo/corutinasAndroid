package com.mitiempo.aprendizajecorutinas.Dagger.EmpaquetadoInicialProyecto.entidades

class Motor (private val tipoMotor : String) : BaseModel {

    fun getTipoMotor() : String{
        return tipoMotor
    }
}