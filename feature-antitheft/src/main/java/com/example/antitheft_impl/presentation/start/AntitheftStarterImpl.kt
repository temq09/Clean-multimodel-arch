package com.example.antitheft_impl.presentation.start

import android.content.Context
import android.content.Intent
import com.example.antitheft_api.AntitheftStarter
import com.example.antitheft_impl.presentation.view.AntitheftActivity

class AntitheftStarterImpl: AntitheftStarter {
    override fun start(context: Context) {
        val intent = Intent(context, AntitheftActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}