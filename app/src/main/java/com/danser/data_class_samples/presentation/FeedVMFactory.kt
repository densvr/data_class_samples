package com.danser.data_class_samples.presentation

import com.danser.data_class_samples.domain.FeedItem
import com.danser.data_class_samples.view.adapter.AdvertViewModel
import com.danser.data_class_samples.view.adapter.OfferViewModel
import java.text.DecimalFormat

class FeedVMFactory {

    private val decimalFormat: DecimalFormat = DecimalFormat("###,###.#")

    fun toViewModel(model: FeedPresentationModel.Model): FeedViewModel {
        val items = model.items.map { item ->
            when(item) {
                is FeedItem.Offer -> item.toViewModel()
                is FeedItem.Advert -> item.toViewModel()
            }
        }
        return FeedViewModel(items)
    }

    private fun FeedItem.Offer.toViewModel(): OfferViewModel = OfferViewModel(
        title = title,
        price = decimalFormat.format(price) + " Р",
        text = text,
        payload = this
    )

    private fun FeedItem.Advert.toViewModel(): AdvertViewModel = AdvertViewModel(
        payload = this
    )


}
