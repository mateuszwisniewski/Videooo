package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.Session
import io.reactivex.Observable

interface SessionRepository {

    val session: Observable<Session>
}