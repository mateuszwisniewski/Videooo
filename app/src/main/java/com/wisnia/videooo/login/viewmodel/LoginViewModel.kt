package com.wisnia.videooo.login.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.wisnia.domain.authentication.repository.LoginRepository
import com.wisnia.domain.authentication.repository.TokenRepository
import com.wisnia.videooo.common.scheduler.RxScheduler
import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToMovies
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignInWebsite
import com.wisnia.videooo.login.navigation.LoginNavigator
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val loginRepository: LoginRepository,
    private val navigator: LoginNavigator,
    private val rxScheduler: RxScheduler
) : LifecycleViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun signIn() {
        disposables +=
            loginRepository.signIn(login.value.orEmpty(), password.value.orEmpty())
                .subscribeOn(rxScheduler.io())
                .observeOn(rxScheduler.mainThread())
                .subscribeBy(
                    onSuccess = {
                        // TODO: not implemented yet
                    },
                    onError = { it.printStackTrace() }
                )
    }

    fun signInWebsite() {
        disposables.plusAssign(
            tokenRepository.token
                .subscribeOn(rxScheduler.io())
                .observeOn(rxScheduler.mainThread())
                .subscribeBy(
                    onSuccess = {
                        navigator.subscribe() // TODO: improve navigator
                        navigator.call(NavigateToSignInWebsite(it))
                    },
                    onError = { it.printStackTrace() }
                )
        )
    }

    fun signInAsGuest() {
        disposables.plusAssign(
            loginRepository.signInAsGuest
                .subscribeOn(rxScheduler.io())
                .observeOn(rxScheduler.mainThread())
                .subscribeBy(
                    onSuccess = {
                        navigator.subscribe() // TODO: improve navigator
                        navigator.call(NavigateToMovies)
                    },
                    onError = { it.printStackTrace() }
                )
        )
    }

    fun onPermissionGranted() {
        navigator.subscribe() // TODO: improve navigator
        navigator.call(NavigateToMovies)
    }

    fun onPermissionDenied() {
        Log.d("LoginActivity", "Authentication failed: User permission denied")
    }
}
