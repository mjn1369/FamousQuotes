package apps.mjn.domain.interactor.base

import apps.mjn.domain.executor.PostExecutionThread
import apps.mjn.domain.executor.UseCaseExecutor
import apps.mjn.domain.observer.SingleObserver
import io.reactivex.Single

abstract class SingleUseCase<Result, in Params>(
    private val useCaseExecutor: UseCaseExecutor,
    private val postExecutionThread: PostExecutionThread
) : UseCase() {
    abstract fun buildSingle(params: Params): Single<Result>

    fun execute(
        params: Params,
        success: (result:Result) -> Unit,
        error: (e: Throwable) -> Unit
    ){
        val observable = buildSingle(params).subscribeOn(useCaseExecutor.scheduler).observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(SingleObserver(success,error)))
    }
}