package com.danser.data_class_samples.repository

import com.danser.data_class_samples.domain.FeedItem
import kotlin.random.Random

interface IOffersRepository {
    fun getItems(count: Int): List<FeedItem.Offer>
}

class OffersRepository : IOffersRepository {

    override fun getItems(count: Int): List<FeedItem.Offer> = (0..count).map { id ->
        when (Random.nextInt(3)) {
            0 -> AUDI
            1 -> BMW
            else -> LADA
        }.copy(id = "$id")
    }

    companion object {
        private val AUDI = FeedItem.Offer(
            id = "0",
            title = "Audi A5б 2017",
            text = "Машина в идеальном состоянии",
            price = 30000000
        )
        private val BMW = FeedItem.Offer(
            id = "0",
            title = "BMW X6, 2019",
            text = "Машина только что из салона",
            price = 400000
        )
        private val LADA = FeedItem.Offer(
            id = "0",
            title = "Лада ВАЗ, 1999",
            text = "Гроб на колесах",
            price = 20000
        )
    }
}
