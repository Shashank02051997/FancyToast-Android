package com.shashank.sony.fancytoastlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

    private static Toast toast;
    private static boolean singleInstance = true;

    public FancyToast(Context context) {
        super(context);
    }

    public static void setSingleInstance(boolean flag) {
        singleInstance = flag;
    }

    private static Toast getToast(Context context) {
        if (toast == null) {
            toast = new Toast(context);
        } else if (!singleInstance) {
            toast = new Toast(context);
        }
        return toast;
    }

    private static View selectTypeAndLayout(Context context, int type, String message) {
        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_icon);
        l1.setText(message);
        if (type == FancyToast.SUCCESS) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(R.drawable.ic_check_black_24dp);
        } else if (type == FancyToast.WARNING) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
        } else if (type == FancyToast.ERROR) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(R.drawable.ic_clear_black_24dp);
        } else if (type == FancyToast.INFO) {
            linearLayout.setBackgroundResource(R.drawable.info_shape);
            img.setImageResource(R.drawable.ic_info_outline_black_24dp);
        } else if (type == FancyToast.DEFAULT) {
            linearLayout.setBackgroundResource(R.drawable.default_shape);
            img.setVisibility(View.GONE);
        } else if (type == FancyToast.CONFUSING) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(R.drawable.ic_refresh_black_24dp);
        }

        return layout;
    }

    public static Toast makeText(Context context, String message, int duration, int type, boolean androidicon) {
        toast = getToast(context);
        toast.setDuration(duration);
        View layout = selectTypeAndLayout(context, type, message);

        // handle the if show android icon or not.
        ImageView img1 = (ImageView) layout.findViewById(R.id.imageView4);
        if (androidicon == true)
            img1.setVisibility(View.VISIBLE);
        else if (androidicon == false)
            img1.setVisibility(View.GONE);

        toast.setView(layout);
        return toast;
    }

    public static Toast makeText(Context context, String message, int duration, int type, int ImageResource) {
        toast = getToast(context);
        View layout = selectTypeAndLayout(context, type, message);
        toast.setView(layout);
        return toast;
    }

}
