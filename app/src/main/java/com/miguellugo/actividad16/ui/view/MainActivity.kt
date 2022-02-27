package com.miguellugo.actividad16.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguellugo.actividad16.R
import com.miguellugo.actividad16.databinding.ActivityMainBinding
import com.miguellugo.actividad16.model.Language
import com.miguellugo.actividad16.ui.adapters.LanguageAdapter

class MainActivity : AppCompatActivity(), LanguageAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var languageAdapter: LanguageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        setUI()
        getLanguages()
    }

    private fun setUI() {
        languageAdapter = LanguageAdapter(this)
        binding.rvLanguages.adapter = languageAdapter
        binding.rvLanguages.layoutManager = LinearLayoutManager(this)
    }

    override fun onLanguageClick(language: Language) {
        val intent = Intent(this, DetailLanguageActivity::class.java)
        intent.putExtra("language", language)
        startActivity(intent)
    }

    private fun getLanguages() {
        val listLanguages = arrayListOf(
            Language(
                "Kotlin",
                getString(R.string.desc_kotlin),
                "https://miro.medium.com/max/1400/1*Kr52kpans_yMI8_9x0GKJQ.png"
            ),Language(
                "Java",
                getString(R.string.desc_java),
                "https://www.campusmvp.es/recursos/image.axd?picture=/2017/4T/Java.png"
            ), Language(
                "Go",
                getString(R.string.desc_go),
                "https://blog.hostalia.com/wp-content/uploads/2019/03/go-lenguaje-programacion-google-blog-hostalia-hosting.jpg"
            ), Language(
                "Python",
                getString(R.string.desc_python),
                "https://byspel.com/wp-content/uploads/2018/12/Python.jpg"
            ), Language(
                "Swift",
                getString(R.string.desc_swift),
                "https://img.blogs.es/anexom/wp-content/uploads/2016/08/Aprende-Swift-2.jpg"
            )
        )
        languageAdapter.setData(listLanguages)
    }
}