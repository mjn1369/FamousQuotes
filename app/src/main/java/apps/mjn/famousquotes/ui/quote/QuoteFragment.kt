package apps.mjn.famousquotes.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.FrameLayout
import apps.mjn.domain.entity.QuoteList
import apps.mjn.famousquotes.R
import apps.mjn.famousquotes.extensions.createViewModel
import apps.mjn.famousquotes.extensions.observe
import apps.mjn.famousquotes.ui.base.BaseFragment
import apps.mjn.famousquotes.ui.model.Resource
import apps.mjn.famousquotes.ui.model.ResourceState
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_quote.*


class QuoteFragment : BaseFragment() {
    companion object {
        fun getInstance() = QuoteFragment()
    }

    private lateinit var viewModel: QuoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = createViewModel(viewModelFactory) {
            observe(getData(), ::handleStates)
        }
        loadQuote()
        setListeners()
    }

    private fun loadQuote() {
        viewModel.load("famous")
    }

    private fun setListeners() {
        btnNextQuote.setOnClickListener {
            loadQuote()
        }
    }

    private fun handleStates(resource: Resource<QuoteList>?) {
        resource?.let {
            when (resource.resourceState) {
                ResourceState.LOADING -> handleLoading()
                ResourceState.SUCCESS -> handleSuccess(resource.data!!)
                ResourceState.ERROR -> handleError(resource.failure!!)
            }
        }
    }

    private fun handleSuccess(data: QuoteList) {
        hideLoading()
        showControls()
        showData(data)
    }

    private fun handleLoading() {
        hideControls()
        showLoading()
    }

    private fun handleError(failure: Throwable) {
        hideControls()
        hideLoading()
        showSnackBar(failure.message)
    }

    private fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    private fun showControls() {
        btnNextQuote.visibility = View.VISIBLE
    }

    private fun hideControls() {
        btnNextQuote.visibility = View.GONE
    }

    private fun showData(data: QuoteList) {
        tvQuoteText.text = data[0].quote
        tvQuoteAuthor.text = data[0].author
    }

    private fun showSnackBar(message: String?) {
        message?.let {
            Snackbar.make(view!!, message, Snackbar.LENGTH_INDEFINITE).apply {
                view.layoutParams = (view.layoutParams as FrameLayout.LayoutParams).apply {
                    setAction(getString(R.string.try_again)) { viewModel.load("famous") }
                }
            }.show()
        }
    }
}