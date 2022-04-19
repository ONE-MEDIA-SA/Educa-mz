package com.app.educa.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.educa.MainActivity
import com.app.educa.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var  auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()

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

            auth.signInWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        binding.emailInputLayout.error = null
                        binding.passwordInputLayout.error = null
                        binding.emailInputLayout.error = "Email or Password is incorrect"
                    }
                }

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

}