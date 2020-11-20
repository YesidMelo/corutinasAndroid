package com.mitiempo.aprendizajecorutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //blockingExample()


    }

    //region bloqueo
    fun longTaskWithMessage(mensaje : String){
        Thread.sleep(4_000)
        Log.e("Mensaje", mensaje +" " +Thread.currentThread().name)

    }

    fun blockingExample(){
        Log.e("Mensaje", "Tarea 1" +" " +Thread.currentThread().name)
        longTaskWithMessage("Tarea 2")
        Log.e("Mensaje", "Tarea 3" +" " +Thread.currentThread().name)
    }
    //endregion
    //region ejemplo de suspend
    suspend fun delayCorutine(mensaje : String){
        delay(timeMillis = 4_000)
        Log.e("Mensaje" , mensaje + " " +Thread.currentThread().name)
    }


    //endregion
}