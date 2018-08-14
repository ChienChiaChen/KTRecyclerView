package com.example.chiachen.ktrecylerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chiachen.ktrecylerview.models.ImageModel
import kotlinx.android.synthetic.main.layout_image_list_item.view.*

class ImageListAdapter(val feedModelItems: List<ImageModel>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_image_list_item, parent, false))

    override fun getItemCount() = feedModelItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindImageModel(feedModelItems[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindImageModel(imageModel: ImageModel) = with(itemView) {
            description_text_view.text = imageModel.imageDescription
            when (imageModel.imageName) {
                "img_1" -> image_view.setImageResource(R.drawable.img_1)
                "img_2" -> image_view.setImageResource(R.drawable.img_2)
                "img_3" -> image_view.setImageResource(R.drawable.img_3)
                "img_4" -> image_view.setImageResource(R.drawable.img_4)
                "img_5" -> image_view.setImageResource(R.drawable.img_5)
                "img_6" -> image_view.setImageResource(R.drawable.img_6)
                "img_7" -> image_view.setImageResource(R.drawable.img_7)
                "img_8" -> image_view.setImageResource(R.drawable.img_8)
                "img_9" -> image_view.setImageResource(R.drawable.img_9)
                "img_10" -> image_view.setImageResource(R.drawable.img_10)
                "img_11" -> image_view.setImageResource(R.drawable.img_11)
                "img_12" -> image_view.setImageResource(R.drawable.img_12)
                "img_13" -> image_view.setImageResource(R.drawable.img_13)
                "img_14" -> image_view.setImageResource(R.drawable.img_14)
                "img_15" -> image_view.setImageResource(R.drawable.img_15)
            }

        }
    }
}