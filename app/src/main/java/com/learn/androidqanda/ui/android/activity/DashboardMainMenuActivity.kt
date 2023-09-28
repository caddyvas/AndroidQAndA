package com.learn.androidqanda.ui.android.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.MainMenuActivityBinding

class DashboardMainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dashboardMainMenu: MainMenuActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dashboardMainMenu = MainMenuActivityBinding.inflate(layoutInflater)
        setContentView(dashboardMainMenu.root)

        dashboardMainMenu.gridCardAndroid.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.gridCardAndroid -> {
                val intent =
                    Intent(this@DashboardMainMenuActivity, AndroidQListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}