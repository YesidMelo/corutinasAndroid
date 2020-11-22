package com.mitiempo.aprendizajecorutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

class EjemploFlow : AppCompatActivity() {
    private val numero_iteraciones = 3
    fun String.imprimirEnConsola(){
        Log.e("Mensaje",this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_flow)
        //un flow es una lista (¿un mapa?) de objetos que se pueden tomar pero de forma asincrona para no bloquear el programa
        //flow es secuencial
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
        /*
        runBlocking {
            thirdFlow().collect { v -> " valor : $v".imprimirEnConsola() }
        }
         */
        //operador map
        /*
        runBlocking {
            (1 .. numero_iteraciones)
                    .asFlow()
                    .map {
                        request ->
                        performRequest(request)
                    }
                    .collect {
                        response ->
                        "imprime respuesta $response".imprimirEnConsola()
                    }
        }
         */
        //operador filter
        /*
        runBlocking {
            (1 .. numero_iteraciones)
                    .asFlow()
                    .filter { request ->
                        return@filter request > 1
                    }
                    .map {
                        request ->
                        performRequest(request)
                    }
                    .collect {
                        value ->
                        "valor : $value".imprimirEnConsola()
                    }
        }
         */
        //operador transform
        /*
        runBlocking {
            (1 .. numero_iteraciones)
                    .asFlow()
                    .transform {
                        request ->
                        emit("haciendo respuesta : $request")//requerde que el emit informa al collect la respuesta
                        emit(performRequest(request))
                    }
                    .collect {
                        response ->
                        "respuesta : $response".imprimirEnConsola()
                    }
        }
         */
        /*
        runBlocking {
            (1 .. numero_iteraciones)
                    .asFlow()
                    .take(2)//indica un limite
                    .collect {
                        response ->
                        "valor : $response".imprimirEnConsola()
                    }
        }
         */
        //operador toList
        /*
        runBlocking {
            val list : List<Int> =  (1 .. numero_iteraciones).asFlow().toList()
            list.toString().imprimirEnConsola()
        }
        */
        /*
        runBlocking {
            val numero =  (1 .. numero_iteraciones).asFlow().first()
            numero.toString().imprimirEnConsola()
        }
        */
        /*
        runBlocking {
            val resultado = (1 .. numero_iteraciones)
                    .asFlow()
                    .reduce{a,b -> a+b} //investigar esto de momentos lo entiendo como una operacion recursiva
            resultado.toString().imprimirEnConsola()
        }
        */
        /*
        runBlocking {
            (1 .. numero_iteraciones * 2)
                    .asFlow()
                    .filter {
                        "numero filtrado : $it".imprimirEnConsola()
                        return@filter it % 2 == 0
                    }
                    .map {
                        "map $it".imprimirEnConsola()
                        "String $it"
                    }
                    .collect {
                        i ->
                        "Collect $i".imprimirEnConsola()
                    }
        }
         */
        //primer ejemplo buffer (sin uso de buffer)-> se demora mas o menos arto
        /*
        runBlocking {
            val time = measureTimeMillis {
                firstFlowBuffer().collect {
                    value ->
                    delay(300)
                    "value : $value".imprimirEnConsola()
                }
            }
            "tiempo : $time".imprimirEnConsola()
        }
        */

        //uso de buffer
        /*
        runBlocking {
            val time = measureTimeMillis {
                firstFlowBuffer()
                        .buffer()
                        .collect {
                            value ->
                            delay(300)
                            "value : $value".imprimirEnConsola()
                        }
            }
            "tiempo  con buffer: $time".imprimirEnConsola()
        }
        */

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
    //region operador Map
    suspend fun performRequest(req : Int) : String{
        delay(1_000)
        return "response $req"
    }
    //endregion
    //region buffer
    fun firstFlowBuffer() : Flow<Int> = flow{
        for (i in 1 .. numero_iteraciones){
            delay(1_00)
            emit(i) // esta linea es la que devolvera un valor en esta funcion de corutina
        }
    }
    //endregion
}