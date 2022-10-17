package com.shashank.sony.fancytoastlib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.IntDef

class FancyToast(context: Context) : Toast(context) {

    companion object {
        @Retention(AnnotationRetention.SOURCE)
        @IntDef(SUCCESS, WARNING, ERROR, INFO, DEFAULT, CONFUSING)
        annotation class LayoutType

        const val SUCCESS = 1
        const val WARNING = 2
        const val ERROR = 3
        const val INFO = 4
        const val DEFAULT = 5
        const val CONFUSING = 6


        @IntDef(LENGTH_SHORT, LENGTH_LONG)
        @Retention(AnnotationRetention.SOURCE)
        annotation class Duration

        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG

        @JvmStatic
        fun makeText(
            context: Context,
            message: CharSequence,
            @Duration duration: Int,
            @LayoutType type: Int,
            androidIcon: Boolean,
        ): Toast {
            val layout = LayoutInflater.from(context)
                .inflate(R.layout.fancytoast_layout, null, false)
            val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
            val imgIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            val imgAndroid = layout.findViewById<ImageView>(R.id.imageView4)
            val toastText = layout.findViewById<TextView>(R.id.toast_text)
            toastText.text = message
            imgAndroid.visibility = if (androidIcon) View.VISIBLE else View.GONE

            when (type) {
                SUCCESS -> {
                    linearLayout.setBackgroundResource(R.drawable.success_shape)
                    imgIcon.setImageResource(R.drawable.ic_check_black_24dp)
                }
                WARNING -> {
                    linearLayout.setBackgroundResource(R.drawable.warning_shape)
                    imgIcon.setImageResource(R.drawable.ic_pan_tool_black_24dp)
                }
                ERROR -> {
                    linearLayout.setBackgroundResource(R.drawable.error_shape)
                    imgIcon.setImageResource(R.drawable.ic_clear_black_24dp)
                }
                INFO -> {
                    linearLayout.setBackgroundResource(R.drawable.info_shape)
                    imgIcon.setImageResource(R.drawable.ic_info_outline_black_24dp)
                }
                CONFUSING -> {
                    linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                    imgIcon.setImageResource(R.drawable.ic_refresh_black_24dp)
                }
                DEFAULT -> {
                    linearLayout.setBackgroundResource(R.drawable.default_shape)
                    imgIcon.visibility = View.GONE
                }
            }

            val toast = Toast(context)
            toast.duration = duration
            toast.view = layout
            return toast
        }


        @JvmStatic
        fun makeText(
            context: Context,
            message: CharSequence?,
            @Duration duration: Int,
            @LayoutType type: Int,
            @DrawableRes ImageResource: Int,
            androidIcon: Boolean
        ): Toast {
            val layout =
                LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false)
            val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
            val imgIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            val imgAndroid = layout.findViewById<ImageView>(R.id.imageView4)
            val toastText = layout.findViewById<TextView>(R.id.toast_text)
            toastText.text = message
            imgIcon.setImageResource(ImageResource)
            imgAndroid.visibility = if (androidIcon) View.VISIBLE else View.GONE

            when (type) {
                SUCCESS -> {
                    linearLayout.setBackgroundResource(R.drawable.success_shape)
                }
                WARNING -> {
                    linearLayout.setBackgroundResource(R.drawable.warning_shape)
                }
                ERROR -> {
                    linearLayout.setBackgroundResource(R.drawable.error_shape)
                }
                INFO -> {
                    linearLayout.setBackgroundResource(R.drawable.info_shape)
                }
                DEFAULT -> {
                    linearLayout.setBackgroundResource(R.drawable.default_shape)
                    imgIcon.visibility = View.GONE
                }
                CONFUSING -> {
                    linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                }
                else -> {
                    linearLayout.setBackgroundResource(R.drawable.default_shape)
                    imgIcon.visibility = View.GONE
                }
            }

            val toast = Toast(context)
            toast.duration = duration
            toast.view = layout
            return toast
        }
    }
}