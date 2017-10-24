package com.shashank.sony.fancytoastlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FancyToast extends Toast {
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     * or {@link Activity} object.
     */
    public static int SUCCESS = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;
    public static int INFO = 4;
    public static int DEFAULT = 5;
    public static int CONFUSING = 6;

    public FancyToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, String message, int duration, int type) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);

        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        AppCompatTextView toastText = layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
        AppCompatImageView img = layout.findViewById(R.id.toast_icon);
        AppCompatImageView appIcon = layout.findViewById(R.id.app_icon);

        toastText.setText(message);
        appIcon.setImageDrawable(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));

        if (type == SUCCESS) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(R.drawable.ic_check_black_24dp);
        } else if (type == WARNING) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
        } else if (type == ERROR) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(R.drawable.ic_clear_black_24dp);
        } else if (type == INFO) {
            linearLayout.setBackgroundResource(R.drawable.info_shape);
            img.setImageResource(R.drawable.ic_info_outline_black_24dp);
        } else if (type == DEFAULT) {
            linearLayout.setBackgroundResource(R.drawable.default_shape);
            img.setVisibility(View.GONE);
        } else if (type == CONFUSING) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(R.drawable.ic_refresh_black_24dp);
        }

        toast.setView(layout);
        return toast;
    }

    public static Toast makeText(Context context, String message, int duration, int type, int imageResource) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);

        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        AppCompatTextView toastText = layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
        AppCompatImageView img = layout.findViewById(R.id.toast_icon);
        AppCompatImageView appIcon = layout.findViewById(R.id.app_icon);

        toastText.setText(message);
        appIcon.setImageDrawable(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));

        if (type == SUCCESS) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
        } else if (type == WARNING) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
        } else if (type == ERROR) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
        } else if (type == INFO) {
            linearLayout.setBackgroundResource(R.drawable.info_shape);
        } else if (type == DEFAULT) {
            linearLayout.setBackgroundResource(R.drawable.default_shape);
        } else if (type == CONFUSING) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
        }

        img.setImageResource(imageResource);
        toast.setView(layout);
        return toast;
    }

}
