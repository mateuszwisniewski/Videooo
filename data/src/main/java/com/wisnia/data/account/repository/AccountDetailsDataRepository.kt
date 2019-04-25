package com.wisnia.data.account.repository

import com.wisnia.data.account.api.AccountDetailsApi
import com.wisnia.data.account.model.toDomain
import com.wisnia.domain.account.model.AccountDetailsModel
import com.wisnia.domain.account.repository.AccountDetailsRepository

class AccountDetailsDataRepository(private val accountDetailsApi: AccountDetailsApi) :
    AccountDetailsRepository {

    override suspend fun accountDetails(): AccountDetailsModel =
        accountDetailsApi.accountDetails()
            .await()
            .toDomain()
}