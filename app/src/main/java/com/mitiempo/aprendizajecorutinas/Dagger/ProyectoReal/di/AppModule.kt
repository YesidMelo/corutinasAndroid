package com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.di

import android.app.Application
import android.content.Context
import com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.models.User
import com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.ui.Login.Login
import com.mitiempo.aprendizajecorutinas.Dagger.ProyectoReal.ui.Login.LoginPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    //region lo que necesitaremos a lo largo de la aplicacion
    @Provides
    @Singleton
    fun provideApplication():Application{
        return application
    }

    @Provides
    @Singleton
    fun provideApplicationContext() : Context {
        return application
    }
    //endregion

    //region user

    @Provides
    @Singleton
    fun provideUser() : User{
        return User()
    }

    //endregion
    //region grafo de activities (presenters)
    @Provides
    @Singleton
    fun providesPresenterLogin(user : User) : Login.Presenter{
         return LoginPresenter(user)
    }
    //endregion
}