package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto


class Motor(var type: String) : BaseModel {

    fun getTypeMotor() : String? { return type }
}