package com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.di.BaseAppLogin
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.models.User
import com.mitiempo.aprendizajecorutinas.dagger.proyectoReal.ui.WebService.WebServiceActivity
import com.mitiempo.aprendizajecorutinas.databinding.ActivityProfileBinding
import javax.inject.Inject
import javax.inject.Named

class ProfileActivity : AppCompatActivity(),Profile.View {

    lateinit var binding : ActivityProfileBinding

    @JvmField
    @Inject
    var presenter : Profile.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as BaseAppLogin).getMyAppComponent().inject(this)
        setUpListeners()
    }

    private fun setUpListeners(){
        binding.textViewLogout.setOnClickListener {  }
        binding.buttonSiguienteActividad.setOnClickListener {
            startActivity(Intent(this,WebServiceActivity::class.java))
        }
        binding.buttonActualizar.setOnClickListener {
            val user = User()
            user.edad = binding.edittextEdad.text.toString()
            user.userName = binding.edittextNombre.text.toString()
            presenter?.updateUser(user)
        }

        presenter?.setMyView(this)
    }

    override fun showUser(user: User) {
        binding.usuario = user
    }


}