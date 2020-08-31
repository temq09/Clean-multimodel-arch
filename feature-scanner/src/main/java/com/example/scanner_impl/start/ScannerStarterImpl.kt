package com.example.scanner_impl.start

import android.content.Context
import android.content.Intent
import com.example.core.di.general.PerFeature
import com.example.scanner_api.ScannerStarter
import com.example.scanner_impl.presentation.view.ScannerActivity
import javax.inject.Inject

@PerFeature
internal class ScannerStarterImpl @Inject constructor() : ScannerStarter {
    override fun start(context: Context) {
        val intent = Intent(context, ScannerActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}