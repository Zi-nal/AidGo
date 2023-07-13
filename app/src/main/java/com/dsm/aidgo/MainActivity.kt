package com.dsm.aidgo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dsm.aidgo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var email = false
        var password = false

        binding.email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                email = p0?.length!! >= 6
                if (email) {
                    if (password) {
                        binding.nextButton.setBackgroundColor(Color.parseColor("#FF3D8AFF"))
                        binding.nextButton.isEnabled = true
                    } else {
                        binding.nextButton.setBackgroundColor(Color.parseColor("#FF9BC2FD"))
                        binding.nextButton.isEnabled = false
                    }
                }
            }
        })
        binding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                password = p0?.length!! >= 6
                if (email) {
                    if (password) {
                        binding.nextButton.setBackgroundColor(Color.parseColor("#FF3D8AFF"))
                        binding.nextButton.isEnabled = true
                    } else {
                        binding.nextButton.setBackgroundColor(Color.parseColor("#FF9BC2FD"))
                        binding.nextButton.isEnabled = false
                    }
                }
            }
        })
        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finishAffinity()
        }

        binding.imageView5.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.sighupText.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}