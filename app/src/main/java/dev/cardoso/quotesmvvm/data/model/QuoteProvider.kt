package dev.cardoso.quotesmvvm.data.model


class QuoteProvider {
    companion object {

        fun random(): QuoteModel {
            val position = (0..11).random()
            //return quotes[position]
            return QuoteModel(1, "cita", "cardoso")
        }

    }
}