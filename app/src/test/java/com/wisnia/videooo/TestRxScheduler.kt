package com.wisnia.videooo

import com.wisnia.videooo.common.scheduler.RxScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers.trampoline

class TestRxScheduler : RxScheduler() {

    override fun mainThread(): Scheduler = trampoline()
    override fun io(): Scheduler = trampoline()
}
