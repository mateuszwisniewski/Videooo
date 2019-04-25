package com.wisnia.data.account.api

import com.wisnia.data.account.model.AccountDetails
import io.reactivex.Single
import retrofit2.http.GET

interface AccountDetailsApi {

    @GET("/account")
    fun accountDetails(): Single<AccountDetails>
}
