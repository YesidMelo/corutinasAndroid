package com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.Motor
import com.mitiempo.aprendizajecorutinas.Dagger.SetupProyecto.di.BaseApplicationSetupDagger
import com.mitiempo.aprendizajecorutinas.R
import javax.inject.Inject
import javax.inject.Named

class SetUpActivity2 : AppCompatActivity() {

    fun String.imprimirEnConsola(){
        Log.e("Mensaje",this)
    }

    @Inject
    @Named("MotorDiesel")
    lateinit var motor : Motor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up2)
        startInjections()
    }

    private fun startInjections() {
        (application as BaseApplicationSetupDagger).traerMotorComponent().inject(this)
        "El motor generado es: ${motor.getTypeMotor()}".imprimirEnConsola()
    }
}