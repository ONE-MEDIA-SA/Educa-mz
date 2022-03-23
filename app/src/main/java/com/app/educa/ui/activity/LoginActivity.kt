package com.app.educa.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.educa.MainActivity
import com.app.educa.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
           checkFields();
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

    }

    private fun checkFields() {
        var email = binding.edEmail.text
        var password = binding.edPassword.text

        if(email.isEmpty()) {
            binding.emailInputLayout.error = "Email is required"
        } else if (password.isEmpty()) {
            binding.emailInputLayout.error = null
            binding.passwordInputLayout.error = "Password is required"
        } else {
            binding.emailInputLayout.error = null
            binding.passwordInputLayout.error = null

            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}