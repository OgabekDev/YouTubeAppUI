package dev.ogabek.youtubeappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.youtubeappui.R
import dev.ogabek.youtubeappui.model.Filter

class FilterAdapter(private val context: Context, private val filters: List<Filter>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
        return FeedFilterViewHolder(view)
    }

    class FeedFilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = filters[position]

        if (holder is FeedFilterViewHolder) {
            holder.apply {
                title.text = filter.title
            }
        }
    }

    override fun getItemCount() = filters.size
}