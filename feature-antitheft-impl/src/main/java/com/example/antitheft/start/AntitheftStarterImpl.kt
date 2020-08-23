package com.example.antitheft.start

import android.content.Context
import android.content.Intent
import com.example.antitheft.presentation.view.AntitheftActivity
import com.example.core.di.general.PerFeature
import com.example.feature_antitheft_api.AntitheftStarter
import javax.inject.Inject

@PerFeature
internal class AntitheftStarterImpl @Inject constructor() : AntitheftStarter {
    override fun start(context: Context) {
        val intent = Intent(context, AntitheftActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}