package com.example.antitheft_impl.presentation.routing

import com.example.antitheft_impl.presentation.view.AntitheftHelpFragment
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

internal object AntitheftRoutingScreens {
    object ANTITHEFT_MAIN: SupportAppScreen() {
        override fun getFragment() = AntitheftMainFragment()
    }
    object ANTITHEFT_HELP: SupportAppScreen() {
        override fun getFragment() = AntitheftHelpFragment()
    }
}