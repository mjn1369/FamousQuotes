package apps.mjn.famousquotes.executor

import apps.mjn.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutionThread {
    override val scheduler: Scheduler by lazy { AndroidSchedulers.mainThread() }
}