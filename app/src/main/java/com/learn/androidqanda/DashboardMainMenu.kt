package com.learn.androidqanda

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.androidqanda.databinding.MainMenuActivityBinding

class DashboardMainMenu : AppCompatActivity() {

    private lateinit var dashboardMainMenu: MainMenuActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dashboardMainMenu = MainMenuActivityBinding.inflate(layoutInflater)
        setContentView(dashboardMainMenu.root)
    }
}