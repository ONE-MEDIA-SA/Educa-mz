package com.app.educa.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.educa.R
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
            binding.passwordInputLayout.error = "Password is required"
        } else {
            binding.emailInputLayout.error = null
            binding.passwordInputLayout.error = null

            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        }
    }
}