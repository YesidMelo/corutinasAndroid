package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile

import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User

class ProfilePresenter(private var user: User) : Profile.Presenter{

    lateinit var view: Profile.View

    override fun setMyView(view: Profile.View) {
        this.view = view
        view.showUser(user)
    }

    override fun updateUser(user: User) {
        this.user.userName = user.userName
        this.user.edad = user.edad
    }
}