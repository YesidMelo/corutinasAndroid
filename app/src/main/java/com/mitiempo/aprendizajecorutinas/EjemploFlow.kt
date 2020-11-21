package com.mitiempo.aprendizajecorutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class EjemploFlow : AppCompatActivity() {
    fun String.imprimirEnConsola(){
        Log.e("Mensaje",this);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_flow)
        show()
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
        for ( i  in 1 .. 3 ){
            Thread.sleep(1_000)
            yield(i)
        }
    }
    //endregon
    //endregion
}