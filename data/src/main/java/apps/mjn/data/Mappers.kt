package apps.mjn.data

import apps.mjn.data.entity.QuoteEntity
import apps.mjn.data.entity.QuoteEntityList
import apps.mjn.domain.entity.Quote
import apps.mjn.domain.entity.QuoteList

fun QuoteEntity.toQuote() = Quote(quote, author, category)

fun QuoteEntityList.toQuoteList(): QuoteList {
    var list = QuoteList()
    forEach { list.add(it.toQuote()) }
    return list
}