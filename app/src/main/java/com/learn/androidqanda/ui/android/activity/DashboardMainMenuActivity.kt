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
        dashboardMainMenu.gridCardArchitecture.setOnClickListener(this)
        dashboardMainMenu.gridCardTitBits.setOnClickListener(this)
        dashboardMainMenu.gridCardEssentials.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        var intent: Intent? = null
        when (view.id) {
            R.id.gridCardAndroid -> {
                intent =
                    Intent(this@DashboardMainMenuActivity, AndroidQListActivity::class.java)
            }

            R.id.gridCardArchitecture -> {
                intent =
                    Intent(this@DashboardMainMenuActivity, AndroidArchitectureActivity::class.java)
            }

            R.id.gridCardTitBits -> {
                intent = Intent(this@DashboardMainMenuActivity, AndroidTitBitsActivity::class.java)
            }

            R.id.gridCardEssentials -> {
                intent =
                    Intent(this@DashboardMainMenuActivity, AndroidEssentialsActivity::class.java)
            }
        }
        startActivity(intent)
    }
}