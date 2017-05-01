package com.wisnia.videooo.network.rest.account

import com.wisnia.videooo.data.account.AccountDetails
import io.reactivex.Observable
import retrofit2.http.GET

interface RestAccountDetailsRepository {

    @get:GET("/account")
    val accountDetails: Observable<AccountDetails>
}