package apps.mjn.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutor {
    val scheduler: Scheduler
}