package com.danser.data_class_samples.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danser.data_class_samples.domain.FeedInteractor
import com.danser.data_class_samples.domain.FeedItem
import com.example.delegateadapter.delegate.diff.IComparableItem

class FeedPresentationModel(
    private val interactor: FeedInteractor = FeedInteractor(),
    private val feedVMFactory: FeedVMFactory = FeedVMFactory()
) : ViewModel() {

    val modelLiveData by lazy {
        MutableLiveData<FeedViewModel>()
    }

    private var model: Model

    init {
        model = Model(interactor.getFeedItems())
        update()
    }

    fun onOfferClicked(offer: FeedItem.Offer) {
        //TODO
    }

    fun onHideAdvertClicked(advert: FeedItem.Advert) {
        //remove advert from the list
        update {
            copy(
                items = items.filterNot { item ->
                    item is FeedItem.Advert && item.id == advert.id
                }
            )
        }
    }

    private fun update(mapper: Model.() -> Model = { this }) {
        model = model.mapper()
        val viewModel = feedVMFactory.toViewModel(model)
        modelLiveData.value = viewModel
    }

    data class Model(
        val items: List<FeedItem>
    )
}

data class FeedViewModel(
    var items: List<IComparableItem>
)
