package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto


class Car constructor(val  motor: Motor): BaseModel {
    fun getCar() : String{ return "the car have a motor : ${motor.getTypeMotor()}" }
}