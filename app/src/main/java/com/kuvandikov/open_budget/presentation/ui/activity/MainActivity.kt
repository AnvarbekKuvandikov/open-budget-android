package com.kuvandikov.open_budget.presentation.ui.activity

import android.os.Bundle
import android.service.autofill.UserData
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.kuvandikov.open_budget.R
import com.kuvandikov.open_budget.databinding.ActivityMainBinding
import com.kuvandikov.open_budget.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navGraph.setStartDestination(R.id.signFragment)
        /*when {
            UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFragment)
            }
            !UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.signFlowFragment)
            }
        }*/
        navController.graph = navGraph
    }
}