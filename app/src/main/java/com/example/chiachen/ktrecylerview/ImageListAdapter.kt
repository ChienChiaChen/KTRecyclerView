package com.example.chiachen.ktrecylerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.chiachen.ktrecylerview.models.ImageModel
import kotlinx.android.synthetic.main.layout_image_list_item.view.*

class ImageListAdapter(private val feedModelItems: List<ImageModel>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_image_list_item, parent, false))

    override fun getItemCount() = feedModelItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindImageModel(feedModelItems[position])
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindImageModel(imageModel: ImageModel) = with(itemView) {
            description_text_view.text = imageModel.imageDescription
            image_view.setImageResource(imageModel.imageName)
        }
    }
}