package com.kuvandikov.open_budget.presentation.ui.fragments.sign.`in`

import android.os.Build.VERSION_CODES.M
import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kuvandikov.open_budget.R
import com.kuvandikov.open_budget.databinding.FragmentSignInBinding
import com.kuvandikov.open_budget.presentation.base.BaseFragment
import com.kuvandikov.open_budget.presentation.extensions.activityNavController
import com.kuvandikov.open_budget.presentation.extensions.navigateSafely
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData


class SignInFragment: BaseFragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    val TAG = "TAG"

    override fun setupListeners() {
        clickSignIn()
        clickSignUp()
//        binding.bannerAdView.setAdUnitId("R-M-338228-9")
//        binding.bannerAdView.setAdUnitId("R-M-1947472-2")
        binding.bannerAdView.setAdUnitId("R-M-1947472-1")


        binding.bannerAdView.setAdSize(AdSize.BANNER_320x50)

        val adRequest = AdRequest.Builder().build()

        // Регистрация слушателя для отслеживания событий, происходящих в баннерной рекламе.
        binding.bannerAdView.setBannerAdEventListener(object : BannerAdEventListener{
            override fun onAdLoaded() {
                Log.d(TAG, "onAdLoaded: ")
            }

            override fun onAdFailedToLoad(error: AdRequestError) {
                Log.d(TAG, "onAdFailedToLoad: ${error.code}: ${error.description}")
            }

            override fun onAdClicked() {
                Log.d(TAG, "onAdClicked: ")
            }

            override fun onLeftApplication() {
                Log.d(TAG, "onLeftApplication: ")
            }

            override fun onReturnedToApplication() {
                Log.d(TAG, "onReturnedToApplication: ")
            }

            override fun onImpression(p0: ImpressionData?) {
                Log.d(TAG, "onImpression: ")
            }

        })

        binding.bannerAdView.loadAd(adRequest)
    }

    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            activityNavController().navigateSafely(R.id.action_global_mainFragment)
        }
    }

    private fun clickSignUp() {
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
}