package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto

class Motor (private val typeMotor : String) : BaseModel {

    fun getTypeMotor() : String { return typeMotor }
}