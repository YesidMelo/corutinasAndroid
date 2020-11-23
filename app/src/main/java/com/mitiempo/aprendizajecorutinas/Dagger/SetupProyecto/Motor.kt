package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto

import javax.inject.Inject

class Motor: BaseModel {
    lateinit var type : String

    @Inject
    constructor(){
        type = "Gasoline"
    }

    constructor (type: String){
        this.type = type
    }

    fun getTypeMotor() : String? { return type }
}