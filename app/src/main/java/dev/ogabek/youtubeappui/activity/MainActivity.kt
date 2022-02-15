package dev.ogabek.youtubeappui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.youtubeappui.R
import dev.ogabek.youtubeappui.adapter.FeedAdapter
import dev.ogabek.youtubeappui.adapter.FilterAdapter
import dev.ogabek.youtubeappui.model.Feed
import dev.ogabek.youtubeappui.model.Filter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerFeed: RecyclerView
    private lateinit var recyclerFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFilter = findViewById(R.id.recyclerFilter)

        recyclerFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshFeedAdapter(getAllFeeds())
        refreshFilterAdapter(getAllFilters())

    }

    private fun refreshFeedAdapter(feeds: List<Feed>) {
        recyclerFeed.adapter = FeedAdapter(this, feeds)
    }

    private fun refreshFilterAdapter(filters: List<Filter>) {
        recyclerFilter.adapter = FilterAdapter(this, filters)
    }

    private fun getAllFeeds(): List<Feed> {
        val feeds: ArrayList<Feed> = ArrayList()
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        feeds.add(Feed(R.drawable.i, R.drawable.video_img))
        return feeds
    }

    private fun getAllFilters(): List<Filter> {
        val filter: ArrayList<Filter> = ArrayList()
        filter.add(Filter("OgabekDev"))
        filter.add(Filter("PDP"))
        filter.add(Filter("Android Programming"))
        filter.add(Filter("Events"))
        filter.add(Filter("Mobile"))
        return filter
    }
}