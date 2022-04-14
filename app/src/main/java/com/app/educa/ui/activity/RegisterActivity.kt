package com.app.educa.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import com.app.educa.MainActivity
import com.app.educa.databinding.ActivityRegisterBinding
import com.app.educa.model.User
import com.app.educa.ui.viewmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        auth= FirebaseAuth.getInstance()

        handleClick()
    }

    private fun handleClick() {
        binding.btnSignup.setOnClickListener {

            var name: String = binding.edName.text.toString()
            var email: String = binding.edEmail.text.toString()
            var password: String = binding.edPassword.text.toString()

            if (name.isEmpty()){
                binding.nameInputLayout.error = "Por favor, insira seu nome"
            } else if (email.isEmpty()){
                binding.nameInputLayout.error = null
                binding.emailInputLayout.error = "Por favor, insira seu email"
            } else if (password.isEmpty()){
                binding.emailInputLayout.error = null
                binding.passwordInputLayout.error = "Por favor, insira seu password"
            } else {
                binding.passwordInputLayout.error = null

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val model: RegisterViewModel by viewModels()

                        var user = User(auth.uid!!, name, email, "", "", arrayListOf())
                        model.createUser(user).observe(this) {                            if (it != null) {
                                Toast.makeText(this, "Usuário criado com sucesso", Toast.LENGTH_LONG
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "Erro ao criar usuário", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }

        }

        binding.tvLogin.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            Intent(this, ForgotPasswordActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}