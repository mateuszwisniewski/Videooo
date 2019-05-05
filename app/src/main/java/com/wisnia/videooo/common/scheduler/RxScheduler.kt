package com.wisnia.videooo.common.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class RxScheduler {

    open fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
    open fun io(): Scheduler = Schedulers.io()
}
