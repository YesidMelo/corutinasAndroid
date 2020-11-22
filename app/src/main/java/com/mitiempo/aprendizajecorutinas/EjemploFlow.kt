package com.mitiempo.aprendizajecorutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class EjemploFlow : AppCompatActivity() {
    private val numero_iteraciones = 3
    fun String.imprimirEnConsola(){
        Log.e("Mensaje",this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_flow)
        /*
//        show()
        runBlocking {
            runAsynchronous().forEach { i -> " $i".imprimirEnConsola() }
        }
         */
        /*
        runBlocking {

            launch {
                for (j in 1 .. numero_iteraciones){
                    "no estoy bloqueado $j".imprimirEnConsola()
                    delay(1_000)
                }
            }

            firstFlow()
                    .collect {//esta linea es la que recoge el valor generado por el emit del flow
                value -> "valor : $value".imprimirEnConsola()
            }
        }
        */
        /*
        //flow cold
        runBlocking {
            "llamand flow ...".imprimirEnConsola()
            val flow : Flow<Int> = firstFlow()
            "collect ...".imprimirEnConsola()
            flow.collect { value -> "numero generado : $value".imprimirEnConsola() }
            "collect again ...".imprimirEnConsola()
            flow.collect { value -> "numero generado : $value".imprimirEnConsola() }
        }
         */
        /*
        //timeout en los flow
        runBlocking {
           withTimeoutOrNull(2500){
               firstFlow().collect { valor -> "valor : $valor".imprimirEnConsola() }
           }
            "Finalizado".imprimirEnConsola()
        }
         */
        /*
        runBlocking {
            secondFlow().collect { v -> "valor : $v".imprimirEnConsola() }
        }
         */
        runBlocking {
            thirdFlow().collect { v -> " valor : $v".imprimirEnConsola() }
        }
    }
    //region introduccion (se bloquea la pantalla por 3 segundos la idea es realizar operaciones de manera asincrona)
    //region ejemplo listar
    fun listar() : List<Int> = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40)
    fun show(){
        //listar().forEach { i-> "numero : $i".imprimirEnConsola() }
        secuencia().forEach { i -> "$i".imprimirEnConsola() }
    }
    //endregion
    //region secuencia
    fun secuencia() : Sequence<Int> = sequence{
        for ( i  in 1 .. numero_iteraciones ){
            Thread.sleep(1_000)
            yield(i)
        }
    }
    //endregon
    //endregion

    //region manejo con corutinas
    suspend fun runAsynchronous() : List<Int>{
        return runBlocking {
            delay(1_000)
            return@runBlocking listar()
        }
    }
    //endregion
    /*
        flow : es un callback que emite valores secuencialmente.
     */
    //region primer flow
    fun firstFlow() : Flow<Int> = flow{
        for (i in 1 .. numero_iteraciones){
            delay(1_000)
            emit(i) // esta linea es la que devolvera un valor en esta funcion de corutina
        }
    }
    //endregion
    //region segunda forma de construir un flow
    fun secondFlow() : Flow<Int> {
        return flowOf(1,2,3)
    }
    //endregion
    //region tercera forma de crear un flow
    fun thirdFlow() : Flow<Int>{
        return ( 1 .. numero_iteraciones).asFlow()
    }
    //endregion
}