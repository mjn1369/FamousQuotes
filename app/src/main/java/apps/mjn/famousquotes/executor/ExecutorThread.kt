package apps.mjn.famousquotes.executor

import apps.mjn.domain.executor.UseCaseExecutor
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class ExecutorThread: UseCaseExecutor{
    override val scheduler: Scheduler by lazy { Schedulers.io() }
}