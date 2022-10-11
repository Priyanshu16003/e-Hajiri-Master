package com.home_department.e_hajirimaster.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.home_department.e_hajirimaster.databinding.ActivityLoginBinding

class LoginActivity : Activity() {

    private lateinit var binding: ActivityLoginBinding
    private  lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Thread.sleep(2000)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            authenticateUser(email,password)
        }
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun authenticateUser(email:String,password:String){

        if(email.isEmpty() && password.isEmpty())
            return Toast.makeText(this,"Enter Both fields",Toast.LENGTH_LONG).show()

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if(!(it.isSuccessful))
                return@addOnCompleteListener Toast.makeText(this,"Wrong UserName or Password",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}