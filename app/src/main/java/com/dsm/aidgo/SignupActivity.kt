package com.dsm.aidgo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.dsm.aidgo.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length!! >= 2) {
                    binding.birthdayText.visibility = View.VISIBLE
                    binding.birthdayInputLayout.visibility = View.VISIBLE
                    binding.birthday.visibility = View.VISIBLE
                } else {
                    binding.birthdayText.visibility = View.GONE
                    binding.birthdayInputLayout.visibility = View.GONE
                    binding.birthday.visibility = View.GONE
                }
            }
        })

        binding.birthday.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length!! == 6) {
                    binding.emailText.visibility = View.VISIBLE
                    binding.emailInputLayout.visibility = View.VISIBLE
                    binding.email.visibility = View.VISIBLE
                } else {
                    binding.emailText.visibility = View.GONE
                    binding.emailInputLayout.visibility = View.GONE
                    binding.email.visibility = View.GONE
                }
            }
        })

        binding.email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (binding.email.length() > 6) {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF3D8AFF"))
                    binding.nextButton.isEnabled = true
                } else {
                    binding.nextButton.setBackgroundColor(Color.parseColor("#FF9BC2FD"))
                    binding.nextButton.isEnabled = false
                }
            }
        })

        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, SignupCodeActivity::class.java))
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