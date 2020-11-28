package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.di

import android.app.Application
import android.content.Context
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Login.Login
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Login.LoginPresenter
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile.Profile
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile.ProfilePresenter
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

    @Provides
    @Singleton
    fun providePresenterProfile(user: User) : Profile.Presenter{
        return ProfilePresenter(user)
    }
    //endregion
}