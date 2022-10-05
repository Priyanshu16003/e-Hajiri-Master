package com.home_department.e_hajirimaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.home_department.e_hajirimaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Thread.sleep(1000)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val navController = findNavController(R.id.fragment)
        binding.bottomNavView.setupWithNavController(navController)


    }
}