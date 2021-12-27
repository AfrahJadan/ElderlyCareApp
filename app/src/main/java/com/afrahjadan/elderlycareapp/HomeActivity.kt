package com.afrahjadan.elderlycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.afrahjadan.elderlycareapp.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {



    private lateinit var binding:ActivityHomeBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth =FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

//        val homeFragment =HomeFragment()//here
//        val profileFragment = ProfileFragment()
//makeCurrentFragment(homeFragment)

        val btnNavView =findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController =findNavController(R.id.HomeNavigationFragment)
        btnNavView.setupWithNavController(navController)
    }
////here
//    private fun makeCurrentFragment(fragment:Fragment){
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.HomeNavigationFragment, fragment)
//            commit()
//        }
//    }

    private fun checkUser() {
       val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser == null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else{
            val email = firebaseUser.email
          //  binding.emailTv.text =email
        }

    }
}