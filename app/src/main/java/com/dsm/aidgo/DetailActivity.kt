package com.dsm.aidgo

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import com.dsm.aidgo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var open = false
        val ic_open: Drawable? = AppCompatResources.getDrawable(this, R.drawable.ic_open)
        val ic_close: Drawable? = AppCompatResources.getDrawable(this, R.drawable.ic_close)

        binding.expendButton.setOnClickListener {
            if (open) {
                binding.expendButton.setBackgroundDrawable(getDrawable(R.drawable.button_gray))
                binding.expendButton.setTextColor(Color.parseColor("#FF5C5C5C"))
                binding.expendButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,ic_open,null)
                binding.content.visibility = View.GONE
                open = false
            } else {
                binding.expendButton.setBackgroundDrawable(getDrawable(R.drawable.button_blue))
                binding.expendButton.setTextColor(Color.parseColor("#FFFFFFFF"))
                binding.expendButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,ic_close,null)
                binding.content.visibility = View.VISIBLE
                open = true
            }
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}