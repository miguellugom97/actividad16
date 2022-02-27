package com.miguellugo.actividad16.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.miguellugo.actividad16.databinding.ActivityDetailLanguageBinding
import com.miguellugo.actividad16.model.Language

class DetailLanguageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailLanguageBinding
    private var language: Language? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        language = intent.getParcelableExtra("language")
        setUI()
    }

    private fun setUI() {
        binding.apply {
            Glide.with(this.root).load(language?.image).into(ivHeaderImage)
            tvName.text = language?.name
            tvDescription.text = language?.description
        }
    }

    override fun onBackPressed() {
        finish()
    }
}