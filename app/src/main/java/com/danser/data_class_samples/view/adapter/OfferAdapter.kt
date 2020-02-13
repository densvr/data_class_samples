package com.danser.data_class_samples.view.adapter

import com.danser.data_class_samples.R
import com.danser.data_class_samples.domain.FeedItem
import com.example.delegateadapter.delegate.KDelegateAdapter
import com.example.delegateadapter.delegate.diff.IComparableItem
import kotlinx.android.synthetic.main.item_offer.*

class OfferAdapter(
    private val onClick: (payload: FeedItem.Offer) -> Unit
): KDelegateAdapter<OfferViewModel>() {

    override fun getLayoutId(): Int = R.layout.item_offer

    override fun onBind(item: OfferViewModel, viewHolder: KViewHolder) = with (viewHolder) {
        tvTitle.text = item.title
        tvText.text = item.text
        itemView.setOnClickListener { onClick(item.payload) }
    }

    override fun isForViewType(items: MutableList<*>, position: Int): Boolean =
        items[position] is OfferViewModel
}

data class OfferViewModel(
    val title: String,
    val price: String,
    val text: String,
    val payload: FeedItem.Offer
): IComparableItem {

    override fun id(): Any = OfferViewModel::javaClass

    override fun content(): Any = this
}
