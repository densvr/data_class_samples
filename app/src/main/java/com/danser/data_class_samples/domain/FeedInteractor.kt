package com.danser.data_class_samples.domain

import com.danser.data_class_samples.repository.AdvertsRepository
import com.danser.data_class_samples.repository.IAdvertsRepository
import com.danser.data_class_samples.repository.IOffersRepository
import com.danser.data_class_samples.repository.OffersRepository

class FeedInteractor(
    private val offersRepo: IOffersRepository = OffersRepository(),
    private val advertsRepo: IAdvertsRepository = AdvertsRepository()
) {
    fun getItems(page: Int): List<Item> =
        offersRepo.getItems(page, 3) + advertsRepo.getItems(page, 1)
}
