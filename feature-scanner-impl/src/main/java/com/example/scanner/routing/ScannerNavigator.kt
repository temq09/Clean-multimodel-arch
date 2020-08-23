package com.example.scanner.routing

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.scanner.presentation.view.ScannerHelpFragment
import com.example.scanner.presentation.view.ScannerMainFragment
import com.example.scanner.routing.ScannerRoutingScreens.SCANNER_HELP
import com.example.scanner.routing.ScannerRoutingScreens.SCANNER_MAIN
import ru.terrakok.cicerone.android.SupportFragmentNavigator

class ScannerNavigator
/**
 * Creates SupportFragmentNavigator.
 *
 * @param fragmentManager support fragment manager
 * @param containerId     id of the fragments container layout
 */(private val mActivityCompat: AppCompatActivity, fragmentManager: FragmentManager?, containerId: Int) : SupportFragmentNavigator(fragmentManager, containerId) {
    override fun createFragment(screenKey: String, data: Any?): Fragment? {
        return when (screenKey) {
            SCANNER_MAIN -> ScannerMainFragment()
            SCANNER_HELP -> ScannerHelpFragment()
            else -> null
        }
    }

    override fun showSystemMessage(message: String) {}
    override fun exit() {
        mActivityCompat.finish()
    }
}