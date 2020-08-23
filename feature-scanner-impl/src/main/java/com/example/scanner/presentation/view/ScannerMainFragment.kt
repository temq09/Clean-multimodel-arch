package com.example.scanner.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.scanner.R
import com.example.scanner.di.ScannerFeatureComponent
import com.example.scanner.presentation.presenter.ScannerPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

internal class ScannerMainFragment : MvpAppCompatFragment(), ScannerMainView {
    @InjectPresenter
    lateinit var scannerPresenter: ScannerPresenter
    @ProvidePresenter
    fun provideScannerPresenter(): ScannerPresenter {
        return ScannerFeatureComponent.get()
                .scannerScreenComponent()
                .scannerPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main_scanner, null)
        view.findViewById<View>(R.id.button_purchase).setOnClickListener { v: View? -> scannerPresenter.clickToBuyWork() }
        view.findViewById<View>(R.id.button_scanner).setOnClickListener { v: View? -> scannerPresenter.clickToScannerWork() }
        view.findViewById<View>(R.id.button_help).setOnClickListener { v: View? -> scannerPresenter.clickToHelp() }
        return view
    }

    override fun showScannerWork() {
        Toast.makeText(context, R.string.scanner_screen_do_scanner_name, Toast.LENGTH_SHORT).show()
    }

    override fun showScannerSuccess() {
        Toast.makeText(context, R.string.scanner_screen_do_scanner_completed_name, Toast.LENGTH_SHORT).show()
    }

    override fun showBuyWork() {
        Toast.makeText(context, R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show()
    }

    override fun showBuySuccess() {
        Toast.makeText(context, R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show()
    }
}