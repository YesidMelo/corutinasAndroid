package com.mitiempo.aprendizajecorutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //blockingExample()
        //suspendExample()
        //suspendExample2()
        dispatcher()


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
    //region runBlocking
    /**
     * runBlocking ejecuta el codigo en el hilo en el que nos encontramos
     */
    fun suspendExample(){
        Log.e("Mensaje", "Tarea 1" +" " +Thread.currentThread().name)
        runBlocking {
            delayCorutine("Tarea 2")
        }
        Log.e("Mensaje", "Tarea 3" +" " +Thread.currentThread().name)
    }

    fun suspendExample2() = runBlocking{
        Log.e("Mensaje", "Tarea 1" +" " +Thread.currentThread().name)
        delayCorutine("Tarea 2")
        Log.e("Mensaje", "Tarea 3" +" " +Thread.currentThread().name)
    }
    //endregion
    //region dispacher
    fun dispatcher(){
        //default
        runBlocking { Log.e("Mensaje","Hilo en el que se ejecuta 1: ${Thread.currentThread().name}") }
        //no nos interesa el hilo en el que se ejecute
        runBlocking(Dispatchers.Unconfined) { Log.e("Mensaje","Hilo en el que se ejecuta 2: ${Thread.currentThread().name}") }

        runBlocking(Dispatchers.Default){ Log.e("Mensaje","Hilo en el que se ejecuta 3: ${Thread.currentThread().name}") }
        //operacion i/o webservice db etc
        runBlocking(Dispatchers.IO){ Log.e("Mensaje","Hilo en el que se ejecuta 4: ${Thread.currentThread().name}") }
        //hilo independiente
        runBlocking(newSingleThreadContext("MiHilo")){ Log.e("Mensaje","Hilo en el que se ejecuta 5: ${Thread.currentThread().name}") }

        //este solo funciona en android, usa el hilo de principal de la aplicacion
        runBlocking(Dispatchers.Main){ Log.e("Mensaje","Hilo en el que se ejecuta 5: ${Thread.currentThread().name}") }
    }
    //endregion
}