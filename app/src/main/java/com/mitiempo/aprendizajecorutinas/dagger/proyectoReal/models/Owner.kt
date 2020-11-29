package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models

import com.google.gson.annotations.SerializedName

class Owner {
    var login : String? = null

    @SerializedName("avatar_url")
    var avatarUrl : String? = null
}