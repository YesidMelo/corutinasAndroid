package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto


class Motor(var type: String) : BaseModel {

    fun getTypeMotor() : String? { return type }
}