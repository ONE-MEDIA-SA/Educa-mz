package com.app.educa.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        }
    }

}