package com.example.eugene_matsyuk.dagger_arch.di.app

import com.example.core.di.general.PerScreen
import com.example.eugene_matsyuk.dagger_arch.presentation.main.presenter.MainPresenter
import dagger.Subcomponent

@Subcomponent
@PerScreen
interface MainScreenComponent {
    fun mainPresenter(): MainPresenter
}