package com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.ui.Login

interface Login{
    interface View{
        fun usuarioValido()
        fun error()
    }
    interface Presenter{
        fun validarUsuario(user : String,pass : String)
        fun setMyView(view : Login.View)
    }

}