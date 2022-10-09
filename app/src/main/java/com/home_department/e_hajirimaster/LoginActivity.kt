package com.home_department.e_hajirimaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.home_department.e_hajirimaster.databinding.ActivityLoginBinding
import com.home_department.e_hajirimaster.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private  lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val client = ApiClient.apiService?.fetchCharacters()
//
//        client?.enqueue(object  : retrofit2.Callback<Demo>{
//            override fun onResponse(
//                call : Call<Demo>,
//                response : Response<Demo>
//            ){
//                if (response.isSuccessful){
//
//                    val result = response.body()?.Duties
//                    result?.let {
//                        Log.d("abc", response.body().toString()+""+result[1])
////                        val adapter = MainAdapter(result)
////                        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
////                        recyclerView?.layoutManager= LinearLayoutManager(applicationContext)
////                        recyclerView?.adapter=adapter
//                    }
//
//                }
//
//            }
//            override fun onFailure(
//                call : Call<Demo>,
//                t : Throwable
//            ){
//                Log.d("fail","hehehehehe")
////                Toast.makeText(this,"Unsuccessful",Toast.LENGTH_SHORT).show()
//            }
//        }
//        )

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener{
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong UserName or Password",Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Enter Both fields",Toast.LENGTH_LONG).show()
            }
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
}