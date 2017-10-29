package com.wisnia.videooo.authentication.presentation

import com.wisnia.videooo.authentication.view.LoginView
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.mvp.BasePresenter
import com.wisnia.videooo.repository.authentication.LoginRepository
import com.wisnia.videooo.repository.authentication.TokenRepository
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val tokenRepository: TokenRepository,
                                         private val loginRepository: LoginRepository,
                                         private val mainThreadScheduler: Scheduler) : BasePresenter<LoginView>() {

    fun signIn(username: String, password: String) {
        loginRepository.signIn(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ onSignIn(it) }, { onError(it) })
    }

    private fun onSignIn(token: Token) {
        view?.get()?.onSignedIn(token)
    }

    fun signInWebsite() {
        tokenRepository.token
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ onSignInWebsite(it) }, { onError(it) })
    }

    private fun onSignInWebsite(token: Token) {
        view?.get()?.onSignedInWebsite(token)
    }

    private fun onError(error: Throwable) {
        view?.get()?.showError(error)
    }

    fun signInAsGuest() {
        TODO("not implemented")
    }
}
