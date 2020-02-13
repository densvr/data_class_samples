package com.danser.data_class_samples.repository

import com.danser.data_class_samples.domain.Item

interface IOffersRepository {
    fun getItems(page: Int, count: Int): List<Item.Offer>
}

class OffersRepository: IOffersRepository {

    override fun getItems(page: Int, count: Int): List<Item.Offer> = listOf(
        AUDI, BMW, LADA
    )

    companion object {
        private val AUDI =  Item.Offer(
            id = "0",
            title = "Audi A5б 2017",
            text = "Машина в идеальном состоянии",
            price = 30000000,
            greenTitle = true
        )
        private val BMW = Item.Offer(
            id = "0",
            title = "BMW X6, 2019",
            text = "Машина только что из салона",
            price = 400000,
            greenTitle = false
        )
        private val LADA = Item.Offer(
            id = "0",
            title = "Лада ВАЗ, 1999",
            text = "Гроб на колесах",
            price = 20000,
            greenTitle = false
        )
    }
}
