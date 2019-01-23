package apps.mjn.famousquotes.ui.quote

import androidx.lifecycle.MutableLiveData
import apps.mjn.domain.entity.QuoteList
import apps.mjn.domain.interactor.GetQuoteUseCase
import apps.mjn.famousquotes.ui.base.BaseViewModel
import apps.mjn.famousquotes.ui.model.Resource
import apps.mjn.famousquotes.ui.model.ResourceState
import javax.inject.Inject

class QuoteViewModel @Inject constructor(private val quoteUseCase: GetQuoteUseCase) : BaseViewModel(){

    private val data: MutableLiveData<Resource<QuoteList>> = MutableLiveData()

    init {
        useCases += quoteUseCase
    }

    fun getData(): MutableLiveData<Resource<QuoteList>> = data

    fun load(quoteType: String){
        data.value = Resource(ResourceState.LOADING)
        quoteUseCase.execute(GetQuoteUseCase.Params(quoteType = quoteType), ::success, ::error)
    }

    private fun success(quote: QuoteList){
        data.value = Resource(ResourceState.SUCCESS, quote)
    }

    private fun error(throwable: Throwable) {
        data.value = Resource(ResourceState.ERROR, failure = throwable)
    }
}