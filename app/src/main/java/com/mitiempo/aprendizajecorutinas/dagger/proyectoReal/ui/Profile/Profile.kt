package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile

import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User

interface Profile {
    interface View{
        fun showUser(user: User)
        fun logout()
    }

    interface Presenter{
        fun setMyView(view: View)
        fun updateUser(user: User)
        fun logout()
    }
}