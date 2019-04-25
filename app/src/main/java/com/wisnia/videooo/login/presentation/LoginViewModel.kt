package com.wisnia.videooo.login.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wisnia.domain.authentication.repository.LoginRepository
import com.wisnia.domain.authentication.repository.TokenRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginType = MutableLiveData<LoginType>()

    suspend fun signIn() {
//        disposables.add(
        loginRepository.signIn(
            login.value.orEmpty(),
            password.value.orEmpty(),
            ""
        )
        /*.subscribeOn(Schedulers.io())
        .observeOn(mainThreadScheduler)
        .subscribe({ loginType.value = LoginType.SignIn }) { it.printStackTrace() }
)*/
    }

    suspend fun signInWebsite() =
//        disposables.add(
        tokenRepository.token()
    /*.subscribeOn(Schedulers.io())
    .observeOn(mainThreadScheduler)
    .subscribe({ loginType.value = LoginType.SignInWeb(it) }) { it.printStackTrace() }
)*/

    suspend fun signInAsGuest() =
//        disposables.add(
        loginRepository.signInAsGuest()
    /*.subscribeOn(Schedulers.io())
    .observeOn(mainThreadScheduler)
    .subscribe({ loginType.value = LoginType.Guest }) { it.printStackTrace() }
)*/

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
