package com.danser.data_class_samples.view.adapter

import com.danser.data_class_samples.R
import com.danser.data_class_samples.domain.FeedItem
import com.example.delegateadapter.delegate.KDelegateAdapter
import com.example.delegateadapter.delegate.diff.IComparableItem
import kotlinx.android.synthetic.main.item_advert.*

class AdvertAdapter(
    private val onHideClick: (FeedItem.Advert) -> Unit
) : KDelegateAdapter<AdvertViewModel>() {

    override fun getLayoutId(): Int = R.layout.item_advert

    override fun onBind(item: AdvertViewModel, viewHolder: KViewHolder) = with(viewHolder) {
        bHide.setOnClickListener { onHideClick(item.payload) }
    }

    override fun isForViewType(items: MutableList<*>, position: Int): Boolean =
        items[position] is AdvertViewModel
}

data class AdvertViewModel(
    val payload: FeedItem.Advert
) : IComparableItem {

    override fun id(): Any = AdvertViewModel::javaClass

    override fun content(): Any = this
}
