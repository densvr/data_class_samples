package com.danser.data_class_samples.domain

sealed class Item(open val id: String) {

    data class Offer(
        override val id: String,
        val title: String,
        val price: Int,
        val greenTitle: Boolean,
        val text: String
    ) : Item(id)

    data class Advert(
        override val id: String,
        val text: String
    ) : Item(id)
}
