package com.app.educa.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.app.educa.MainActivity
import com.app.educa.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        handleClick()
    }

    private fun handleClick() {
        binding.tvLogin.setOnClickListener {

            var name: String = binding.edName.text.toString()
            var email: String = binding.edEmail.text.toString()
            var password: String = binding.edPassword.text.toString()

            if (name.isEmpty()){
                binding.nameInputLayout.error = "Por favor, insira seu nome"
            } else if (email.isEmpty()){
                binding.emailInputLayout.error = "Por favor, insira seu email"
            } else if (password.isEmpty()){
                binding.passwordInputLayout.error = "Por favor, insira seu password"
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

        }

        binding.tvForgotPassword.setOnClickListener {
            Intent(this, ForgotPasswordActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}