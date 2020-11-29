package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.api

import androidx.lifecycle.LiveData
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.GitHubRepo
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.github.com/
interface ApiClient {
    @GET("users/{user}/received_events")
    fun getReposForUser(@Path("user") user: User):MutableList<GitHubRepo>
}