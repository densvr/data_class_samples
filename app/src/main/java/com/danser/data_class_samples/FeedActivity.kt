package com.danser.data_class_samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.danser.data_class_samples.domain.FeedInteractor
import com.danser.data_class_samples.view.adapter.AdvertAdapter
import com.danser.data_class_samples.view.adapter.OfferAdapter
import com.example.delegateadapter.delegate.diff.DiffUtilCompositeAdapter
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    private val adapter: DiffUtilCompositeAdapter by lazy { getDiffAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        bindRecycler()
    }

    private fun bindRecycler() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun update() {
        adapter.swapData(FeedInteractor().getFeedItems(0))
    }

    private fun getDiffAdapter(): DiffUtilCompositeAdapter = DiffUtilCompositeAdapter.Builder()
        .add(OfferAdapter {})
        .add(AdvertAdapter {})
        .build()
}
