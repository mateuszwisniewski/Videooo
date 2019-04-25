package com.wisnia.domain.account.repository

import com.wisnia.domain.account.model.AccountDetailsModel
import io.reactivex.Single

interface AccountDetailsRepository {

    fun accountDetails(): Single<AccountDetailsModel>
}