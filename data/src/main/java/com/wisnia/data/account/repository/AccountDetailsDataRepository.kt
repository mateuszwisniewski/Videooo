package com.wisnia.data.account.repository

import com.wisnia.data.account.api.AccountDetailsApi
import com.wisnia.data.account.model.toDomain
import com.wisnia.domain.account.model.AccountDetailsModel
import com.wisnia.domain.account.repository.AccountDetailsRepository
import io.reactivex.Single

class AccountDetailsDataRepository(private val accountDetailsApi: AccountDetailsApi) :
    AccountDetailsRepository {

    override fun accountDetails(): Single<AccountDetailsModel> =
        accountDetailsApi.accountDetails()
            .map { it.toDomain() }
}
