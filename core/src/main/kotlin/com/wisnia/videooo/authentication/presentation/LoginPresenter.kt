package com.wisnia.videooo.authentication.presentation

import com.wisnia.videooo.authentication.view.LoginView
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.mvp.BasePresenter
import com.wisnia.videooo.repository.authentication.TokenRepository
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val tokenRepository: TokenRepository,
                                         private val mainThreadScheduler: Scheduler) : BasePresenter<LoginView>() {

    fun signIn() {
        tokenRepository.token
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ onTokenReceived(it) }, { onError(it) })
    }

    private fun onError(error: Throwable) {
        view?.get()?.showError(error)
    }

    private fun onTokenReceived(token: Token) {
        view?.get()?.onTokenReceived(token)
    }

    fun signInAsGuest() {
        TODO("not implemented")
    }
}
