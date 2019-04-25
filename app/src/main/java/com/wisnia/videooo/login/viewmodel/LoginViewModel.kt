package com.wisnia.videooo.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wisnia.domain.authentication.repository.LoginRepository
import com.wisnia.domain.authentication.repository.TokenRepository
import com.wisnia.videooo.common.scheduler.RxScheduler
import com.wisnia.videooo.login.presentation.LoginType
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val loginRepository: LoginRepository,
    private val rxScheduler: RxScheduler
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginType = MutableLiveData<LoginType>()

    fun signIn() {
        disposables.add(
            loginRepository.signIn(
                login.value.orEmpty(),
                password.value.orEmpty()
            )
                .subscribeOn(rxScheduler.io)
                .observeOn(rxScheduler.mainThread)
                .subscribe({ loginType.value = LoginType.SignIn }) { it.printStackTrace() }
        )
    }

    fun signInWebsite() =
        disposables.add(
            tokenRepository.token
                .subscribeOn(rxScheduler.io)
                .observeOn(rxScheduler.mainThread)
                .subscribe({ loginType.value = LoginType.SignInWeb(it) }) { it.printStackTrace() }
        )

    fun signInAsGuest() =
        disposables.add(
            loginRepository.signInAsGuest
                .subscribeOn(rxScheduler.io)
                .observeOn(rxScheduler.mainThread)
                .subscribe({ loginType.value = LoginType.Guest }) { it.printStackTrace() }
        )

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
