package com.wisnia.videooo.common.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class RxScheduler {

    val mainThread: Scheduler = AndroidSchedulers.mainThread()
    val io: Scheduler = Schedulers.io()
}
