package com.mitiempo.aprendizajecorutinas.dagger.SetupProyecto


class Car constructor(val  motor: Motor): BaseModel {
    fun getCar() : String{ return "the car have a motor : ${motor.getTypeMotor()}" }
}