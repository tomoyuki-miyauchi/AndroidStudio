package com.example.janken

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.preference.PreferenceManager
import com.example.janken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gu.setOnClickListener { onJankenButtunTapped(it) }
        binding.choki.setOnClickListener { onJankenButtunTapped(it) }
        binding.pa.setOnClickListener { onJankenButtunTapped(it) }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            clear()
        }
    }

    fun onJankenButtunTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra( "MY_HAND", view?.id )
        startActivity(intent)
    }
}
