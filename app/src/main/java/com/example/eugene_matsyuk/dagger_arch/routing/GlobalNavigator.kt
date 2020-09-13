package com.example.eugene_matsyuk.dagger_arch.routing

import android.content.Context
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.scanner_api.ScannerFeatureApi
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class GlobalNavigator @Inject constructor(
        private val featureScanner: Provider<ScannerFeatureApi>,
        private val featureAntitheft: Provider<AntitheftFeatureApi>,
        private val context: Context
) : Navigator {
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
                featureScanner.get().scannerStarter().start(context)
                return
            }
            GlobalScreenNames.AV_FEATURE -> {
                featureAntitheft.get().antitheftStarter().start(context)
                return
            }
            else -> throw RuntimeException("Unexpected screen: $name")
        }
    }
}