package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Login

import android.util.Log
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest : TestCase() {

    @Mock
    lateinit var view : Login.View

    var presenter : LoginPresenter? = null
    val user = User()

    @Before
    public override fun setUp() {
        user.userName = "alberto"
        user.password = "1234"

        presenter = LoginPresenter(user)
        presenter?.setMyView(view)
        Log.e("Mensaje","SetUp : $presenter")

        super.setUp()
    }

    @After
    public override fun tearDown() {}

    @Test
    fun shouldShowUserValidWhenUserAndPasswordIsCorrect(){
        Log.e("Mensaje","El presenter es : $presenter")
        presenter?.validarUsuario(this.user.userName!!,this.user.password!!)
        verify(view).usuarioValido()
    }
}