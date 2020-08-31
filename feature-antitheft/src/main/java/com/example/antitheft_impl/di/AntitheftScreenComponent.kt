package com.example.antitheft_impl.di

import com.example.antitheft_impl.presentation.presenter.AntitheftPresenter
import com.example.core.di.general.PerScreen
import dagger.Subcomponent

@Subcomponent
@PerScreen
internal interface AntitheftScreenComponent {
    fun antitheftPresenter(): AntitheftPresenter
}