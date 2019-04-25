package com.wisnia.data.account.api

import com.wisnia.data.account.model.AccountDetails
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AccountDetailsApi {

    @GET("/account")
    fun accountDetails(): Deferred<AccountDetails>
}
