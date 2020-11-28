package com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.ui.Login

import com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.models.User
import java.util.*

class LoginPresenter(private val user: User) :Login.Presenter {

    var view: Login.View? = null


    override fun setMyView(view: Login.View) {
        this.view = view
    }

    override fun validarUsuario(user: String, pass: String) {
        if (user.toLowerCase(Locale.getDefault()) == "alberto" && pass.toLowerCase(Locale.getDefault()) == "1234") {
            this.user.userName ="Alberto Palomar"
            this.user.edad="30"
            view?.usuarioValido()
        } else {
            view?.error()
        }
    }

}