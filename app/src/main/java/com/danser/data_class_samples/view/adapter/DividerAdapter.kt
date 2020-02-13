package com.danser.data_class_samples.view.adapter

import com.danser.data_class_samples.R
import com.example.delegateadapter.delegate.KDelegateAdapter
import com.example.delegateadapter.delegate.diff.IComparableItem

object DividerAdapter : KDelegateAdapter<DividerItem>() {
    override fun getLayoutId(): Int = R.layout.item_divider

    override fun isForViewType(items: MutableList<*>, position: Int): Boolean =
        items[position] == DividerItem

    override fun onBind(item: DividerItem, viewHolder: KViewHolder) {
        //do nothing
    }
}

object DividerItem: IComparableItem {
    override fun id(): Any = this
    override fun content(): Any = this
}
