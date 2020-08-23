package com.example.antitheft.routing

import com.example.antitheft.presentation.view.AntitheftHelpFragment
import com.example.antitheft.presentation.view.AntitheftMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

internal object AntitheftRoutingScreens {
    object ANTITHEFT_MAIN: SupportAppScreen() {
        override fun getFragment() = AntitheftMainFragment()
    }
    object ANTITHEFT_HELP: SupportAppScreen() {
        override fun getFragment() = AntitheftHelpFragment()
    }
}