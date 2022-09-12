package com.kuvandikov.open_budget.presentation.ui.fragments.main

import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kuvandikov.open_budget.R
import com.kuvandikov.open_budget.databinding.FragmentMainBinding
import com.kuvandikov.open_budget.presentation.base.BaseNavHostFragment

class MainFragment : BaseNavHostFragment(
    R.layout.fragment_main, R.id.nav_host_fragment_main
) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun setupNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}