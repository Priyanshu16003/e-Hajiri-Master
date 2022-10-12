package com.home_department.e_hajirimaster.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.home_department.e_hajirimaster.R
import com.home_department.e_hajirimaster.activity.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoreOptions : Fragment(R.layout.more_options) {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        val btnLogOut = view.findViewById<Button>(R.id.btnLogOut)
        btnLogOut.setOnClickListener { CoroutineScope(Dispatchers.IO).launch { signOut() }  }

    }

    private fun signOut() {
        firebaseAuth.signOut()
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
}