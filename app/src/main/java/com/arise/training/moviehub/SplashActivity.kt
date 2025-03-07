package com.arise.training.moviehub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            delay(3000)
            goToMainActivity()
//            finish()
        }
        Log.d("testapp splash", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("testapp splash", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("testapp splash", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("testapp splash", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("testapp splash", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("testapp splash", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("testapp splash", "onRestart")
    }

    fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(EXTRA_NAME, "Bee Splash")
        startActivity(intent)
    }


    companion object {
        const val EXTRA_NAME = "EXTRA_HI"
    }
}