package com.dsm.aidgo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.dsm.aidgo.databinding.ActivitySignupPasswordBinding

class SignupPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length!! >= 6) {
                    binding.passwordValidText.visibility = View.VISIBLE
                    binding.passwordValidInputLayout.visibility = View.VISIBLE
                    binding.passwordValid.visibility = View.VISIBLE
                }
                if (binding.password.text == binding.passwordValid.text) {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF3D8AFF"))
                    binding.nextButton.isEnabled = true
                } else {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF9BC2FD"))
                    binding.nextButton.isEnabled = false
                }
            }
        })

        binding.passwordValid.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (binding.password.text.toString() == binding.passwordValid.text.toString()) {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF3D8AFF"))
                    binding.nextButton.isEnabled = true
                } else {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF9BC2FD"))
                    binding.nextButton.isEnabled = false
                }
            }
        })

        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, SignupSchoolActivity::class.java))
        }


        binding.loginText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}