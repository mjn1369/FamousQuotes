package apps.mjn.remote

import apps.mjn.data.entity.QuoteEntity
import apps.mjn.data.entity.QuoteEntityList
import apps.mjn.remote.dto.QuoteDTO
import apps.mjn.remote.dto.QuoteListDTO

fun QuoteDTO.toQuoteEntity() = QuoteEntity(quote, author, category)

fun QuoteListDTO.toQuoteListEntity(): QuoteEntityList {
    var list = QuoteEntityList()
    forEach { list.add(it.toQuoteEntity()) }
    return list
}