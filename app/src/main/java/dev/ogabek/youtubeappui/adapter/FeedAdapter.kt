package dev.ogabek.youtubeappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dev.ogabek.youtubeappui.R
import dev.ogabek.youtubeappui.model.Feed

class FeedAdapter(private val context: Context, private val feeds: List<Feed>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedVideoViewHolder(view)
    }

    class FeedVideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoPhoto: ImageView = view.findViewById(R.id.iv_video)
        val profileImage: ShapeableImageView = view.findViewById(R.id.iv_profile)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = feeds[position]

        if (holder is FeedVideoViewHolder) {
            holder.apply {
                videoPhoto.setImageResource(feed.photo)
                profileImage.setImageResource(feed.profile)
            }
        }
    }

    override fun getItemCount() = feeds.size
}