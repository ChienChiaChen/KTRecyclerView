package com.example.chiachen.ktrecylerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.chiachen.ktrecylerview.models.ImageModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imageList by lazy {
        listOf(
                ImageModel(R.drawable.img_1, "This is a photo of 1"),
                ImageModel(R.drawable.img_2, "This is a photo of 2"),
                ImageModel(R.drawable.img_3, "This is a photo of 3"),
                ImageModel(R.drawable.img_4, "This is a photo of 4"),
                ImageModel(R.drawable.img_5, "This is a photo of 5"),
                ImageModel(R.drawable.img_6, "This is a photo of 6"),
                ImageModel(R.drawable.img_7, "This is a photo of 7"),
                ImageModel(R.drawable.img_8, "This is a photo of 8"),
                ImageModel(R.drawable.img_9, "This is a photo of 9"),
                ImageModel(R.drawable.img_10, "This is a photo of 10"),
                ImageModel(R.drawable.img_11, "This is a photo of 11"),
                ImageModel(R.drawable.img_12, "This is a photo of 12"),
                ImageModel(R.drawable.img_13, "This is a photo of 13"),
                ImageModel(R.drawable.img_14, "This is a photo of 14"),
                ImageModel(R.drawable.img_15, "This is a photo of 15")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Image List"

        imageListRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ImageListAdapter(imageList)
        imageListRecyclerView.adapter = adapter
        imageListRecyclerView.addOnItemTouchListener(
                CustomRecyclerViewTouchListenert(this, imageListRecyclerView,
                        { _, position -> Toast.makeText(this, "Click $position", Toast.LENGTH_SHORT).show() },
                        { _, position -> Toast.makeText(this, "Long Click $position", Toast.LENGTH_SHORT).show() }))
    }
}
