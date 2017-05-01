package com.wisnia.videooo.repository.account

import com.wisnia.videooo.data.account.AccountDetails
import io.reactivex.Observable

interface AccountDetailsRepository {

    val accountDetails: Observable<AccountDetails>
}