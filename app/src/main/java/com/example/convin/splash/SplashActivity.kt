package com.example.convin.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.convin.R
import com.example.convin.databinding.ActivitySplashBinding
import com.example.convin.main.MainActivity

class SplashActivity : AppCompatActivity() {

    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_splash)

        //
        initTheme()
        gotoMainActivity()
    }

    private fun gotoMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 500
        )
    }

    private fun initTheme(){
        window.statusBarColor = resources.getColor(R.color.lightBlack)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }
}