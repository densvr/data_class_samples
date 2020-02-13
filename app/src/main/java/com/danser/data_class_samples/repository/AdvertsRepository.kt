package com.danser.data_class_samples.repository

import com.danser.data_class_samples.domain.Item

interface IAdvertsRepository {
    fun getItems(page: Int, count: Int): List<Item.Advert>
}

class AdvertsRepository: IAdvertsRepository {

    override fun getItems(page: Int, count: Int): List<Item.Advert> = listOf(
        Item.Advert(
            "0",
            "Покупайте квартиры в СПб от ЛенСпецМу"
        )
    )
}
