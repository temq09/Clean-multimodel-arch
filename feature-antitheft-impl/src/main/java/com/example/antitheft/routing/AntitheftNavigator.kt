package com.example.antitheft.routing

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.antitheft.presentation.view.AntitheftHelpFragment
import com.example.antitheft.presentation.view.AntitheftMainFragment
import ru.terrakok.cicerone.android.SupportFragmentNavigator

/**
 * Creates SupportFragmentNavigator.
 *
 * @param fragmentManager support fragment manager
 * @param containerId     id of the fragments container layout
 */
class AntitheftNavigator(private val activityCompat: AppCompatActivity, fragmentManager: FragmentManager?, containerId: Int) : SupportFragmentNavigator(fragmentManager, containerId) {
    override fun createFragment(screenKey: String, data: Any?): Fragment? {
        return when (screenKey) {
            AntitheftRoutingScreens.ANTITHEFT_MAIN -> AntitheftMainFragment()
            AntitheftRoutingScreens.ANTITHEFT_HELP -> AntitheftHelpFragment()
            else -> null
        }
    }

    override fun showSystemMessage(message: String) {}
    override fun exit() {
        activityCompat.finish()
    }
}