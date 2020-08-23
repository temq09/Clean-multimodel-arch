package com.example.eugene_matsyuk.dagger_arch.routing

import android.content.Context
import com.example.eugene_matsyuk.dagger_arch.di.FeatureProxyInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalNavigator @Inject constructor(private val mContext: Context) : Navigator {
    override fun applyCommands(commands: Array<Command>) {
        for (command in commands) {
            applyCommand(command)
        }
    }

    private fun applyCommand(command: Command) {
        if (command is Forward) {
            forward(command)
            return
        }
        throw RuntimeException("Unexpected action")
    }

    private fun forward(command: Forward) {
        val name = command.screen
        startFeatureStartPoint(name)
    }

    private fun startFeatureStartPoint(name: Screen) {
        when (name) {
            GlobalScreenNames.SCANNER_FEATURE -> {
                FeatureProxyInjector.featureScanner.scannerStarter().start(mContext)
                return
            }
            GlobalScreenNames.AV_FEATURE -> {
                FeatureProxyInjector.featureAntitheft.antitheftStarter().start(mContext)
                return
            }
            else -> throw RuntimeException("Unexpected screen: $name")
        }
    }
}