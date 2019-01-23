package apps.mjn.domain.interactor

import apps.mjn.domain.entity.Quote
import apps.mjn.domain.entity.QuoteList
import apps.mjn.domain.executor.PostExecutionThread
import apps.mjn.domain.executor.UseCaseExecutor
import apps.mjn.domain.interactor.base.SingleUseCase
import apps.mjn.domain.repository.QuoteRepository
import io.reactivex.Single
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val useCaseExecutor: UseCaseExecutor,
    private val postExecutionThread: PostExecutionThread
) : SingleUseCase<QuoteList, GetQuoteUseCase.Params>(useCaseExecutor, postExecutionThread) {

    override fun buildSingle(params: Params): Single<QuoteList> {
        return quoteRepository.getQuote(params.quoteType)
    }

    data class Params(val quoteType: String = "famous")
}