package com.wisnia.domain.account.repository

import com.wisnia.domain.account.model.AccountDetailsModel

interface AccountDetailsRepository {

    suspend fun accountDetails(): AccountDetailsModel
}