package com.wisnia.videooo.login.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wisnia.videooo.extension.EMPTY
import com.wisnia.videooo.repository.authentication.LoginRepository
import com.wisnia.videooo.repository.authentication.TokenRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val loginRepository: LoginRepository,
    private val mainThreadScheduler: Scheduler
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginType = MutableLiveData<LoginType>()

    fun signIn() {
        disposables.add(
            loginRepository.signIn(
                login.value ?: String.EMPTY,
                password.value ?: String.EMPTY
            )
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ loginType.value = LoginType.SignIn }) { it.printStackTrace() }
        )
    }

    fun signInWebsite() =
        disposables.add(
            tokenRepository.token
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ loginType.value = LoginType.SignInWeb(it) }) { it.printStackTrace() }
        )

    fun signInAsGuest() =
        disposables.add(
            loginRepository.signInAsGuest
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe({ loginType.value = LoginType.Guest }) { it.printStackTrace() }
        )

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
