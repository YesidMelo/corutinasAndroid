package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.di.BaseAppLogin
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile.ProfileActivity
import com.mitiempo.aprendizajecorutinas.databinding.ActivityLoginBinding
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named

class LoginActivity : AppCompatActivity(),Login.View {

    lateinit var binding : ActivityLoginBinding

    //ui
    @JvmField
    @Inject
    var presenter : Login.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
        setUpInjection()
    }

    //region metodos privados
    private fun setUpInjection(){
        (application as BaseAppLogin).getMyAppComponent().inject(this)
    }

    private fun setUpListeners(){
        binding.buttonLogin.setOnClickListener {
            presenter?.setMyView(this)
            presenter?.validarUsuario(
                binding.editTextUsername.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }

    }
    //endregion
    override fun error() = runBlocking {
        Toast.makeText(this@LoginActivity,"usuario invalido",Toast.LENGTH_LONG).show()
    }

    override fun usuarioValido() = runBlocking {
        startActivity(Intent(this@LoginActivity,ProfileActivity::class.java))
    }

}