package com.kuvandikov.open_budget.presentation.ui.fragments.sign.`in`

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kuvandikov.open_budget.R
import com.kuvandikov.open_budget.databinding.FragmentSignInBinding
import com.kuvandikov.open_budget.presentation.extensions.activityNavController
import com.kuvandikov.open_budget.presentation.extensions.navigateSafely
class SignInFragment: Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        clickSignIn()
        clickSignUp()
    }

    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            activityNavController().navigateSafely(R.id.action_global_mainFragment)
        }
    }

    private fun clickSignUp() {
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_global_signFragment)
        }
    }
}