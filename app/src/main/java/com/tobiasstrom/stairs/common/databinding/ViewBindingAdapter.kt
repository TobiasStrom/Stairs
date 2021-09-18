package com.tobiasstrom.stairs.common.databinding

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.tobiasstrom.stairs.common.extensions.onFinishedEditing

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun setVisibleOrGone(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("onFinishEditing")
    fun setOnFinishEditing(view: EditText, onFinishEditing: () -> Unit) {
        view.onFinishedEditing(onFinishEditing)
    }
}
