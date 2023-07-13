package com.dsm.aidgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsm.aidgo.databinding.ActivitySignupSchoolBinding

class SignupSchoolActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupSchoolBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupSchoolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = SchoolDialog()
        dialog.show(supportFragmentManager, "SchoolDialog")

        binding.loginText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}