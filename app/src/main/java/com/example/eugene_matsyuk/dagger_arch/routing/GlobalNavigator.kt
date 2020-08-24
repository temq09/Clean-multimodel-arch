package com.example.eugene_matsyuk.dagger_arch.routing

import android.content.Context
import com.example.feature_antitheft_api.AntitheftFeatureApi
import com.example.feature_scanner_api.ScannerFeatureApi
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalNavigator @Inject constructor(
        private val featureScanner: ScannerFeatureApi,
        private val featureAntitheft: AntitheftFeatureApi,
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
                featureScanner.scannerStarter().start(context)
                return
            }
            GlobalScreenNames.AV_FEATURE -> {
                featureAntitheft.antitheftStarter().start(context)
                return
            }
            else -> throw RuntimeException("Unexpected screen: $name")
        }
    }
}