package com.example.chiachen.ktrecylerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class CustomRecyclerViewTouchListenert(context: Context,
                                       private val recyclerView: RecyclerView,
                                       private val onClickListener: ((view: View, position: Int) -> Unit),
                                       private val onLongClickListener: ((view: View, position: Int) -> Unit)) : RecyclerView.OnItemTouchListener {

    private var gestureDetector: GestureDetector? = null

    init {
        gestureDetector = GestureDetector(context, object:GestureDetector.SimpleOnGestureListener(){
            override fun onLongPress(e: MotionEvent) {
                super.onLongPress(e)
                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                if (childView != null) {
                    onLongClickListener.invoke(childView, recyclerView.getChildLayoutPosition(childView))
                }
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean = true
        })
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val childView = rv.findChildViewUnder(e.x, e.y)
        if (childView != null && gestureDetector?.onTouchEvent(e) == true) {
            onClickListener.invoke(childView, rv.getChildLayoutPosition(childView))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }
}