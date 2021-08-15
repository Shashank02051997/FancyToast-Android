package com.shashank.sony.fancytoastlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FancyToast extends Toast {
    
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({SUCCESS, WARNING, ERROR, INFO, DEFAULT, CONFUSING})
    public @interface LayoutType {}
    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int DEFAULT = 5;
    public static final int CONFUSING = 6;


    @IntDef({ LENGTH_SHORT, LENGTH_LONG })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {}
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     * <p>
     *
     * @param context The context to use.  Usually your {@link Application}
     * or {@link Activity} object.
     */
    public FancyToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, CharSequence message, @Duration int duration, @LayoutType int type, boolean androidIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        TextView l1 = layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
        ImageView img = layout.findViewById(R.id.toast_icon);
        ImageView img1 = layout.findViewById(R.id.imageView4);
        l1.setText(message);
        if (androidIcon) {
            drawAppIcon(img1);
            img1.setVisibility(View.VISIBLE);
        } else img1.setVisibility(View.GONE);
        switch (type) {
            case 1:
                linearLayout.setBackgroundResource(R.drawable.success_shape);
                img.setImageResource(R.drawable.ic_check_black_24dp);
                break;
            case 2:
                linearLayout.setBackgroundResource(R.drawable.warning_shape);
                img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
                break;
            case 3:
                linearLayout.setBackgroundResource(R.drawable.error_shape);
                img.setImageResource(R.drawable.ic_clear_black_24dp);
                break;
            case 4:
                linearLayout.setBackgroundResource(R.drawable.info_shape);
                img.setImageResource(R.drawable.ic_info_outline_black_24dp);
                break;
            case 5:
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                img.setVisibility(View.GONE);
                break;
            case 6:
                linearLayout.setBackgroundResource(R.drawable.confusing_shape);
                img.setImageResource(R.drawable.ic_refresh_black_24dp);
                break;
        }
        toast.setView(layout);
        return toast;
    }


    public static Toast makeText(Context context, CharSequence message, @Duration int duration, @LayoutType int type, int ImageResource, boolean androidIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        TextView l1 = layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = layout.findViewById(R.id.toast_type);
        ImageView img = layout.findViewById(R.id.toast_icon);
        ImageView img1 = layout.findViewById(R.id.imageView4);
        l1.setText(message);
        img.setImageResource(ImageResource);
        if (androidIcon) {
            drawAppIcon(img1);
            img1.setVisibility(View.VISIBLE);
        } else img1.setVisibility(View.GONE);
        switch (type) {
            case 1:
                linearLayout.setBackgroundResource(R.drawable.success_shape);
                break;
            case 2:
                linearLayout.setBackgroundResource(R.drawable.warning_shape);
                break;
            case 3:
                linearLayout.setBackgroundResource(R.drawable.error_shape);
                break;
            case 4:
                linearLayout.setBackgroundResource(R.drawable.info_shape);
                break;
            case 5: {
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                img.setVisibility(View.GONE);
                break;
            }
            case 6:
                linearLayout.setBackgroundResource(R.drawable.confusing_shape);
                break;
            default:
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                img.setVisibility(View.GONE);
                break;
        }
        toast.setView(layout);
        return toast;
    }


    private static void drawAppIcon(ImageView iv) {
        Context context = iv.getContext();
        try {
            Drawable icon = context.getPackageManager().getApplicationIcon(context.getPackageName());
            iv.setImageDrawable(icon);
        } catch (PackageManager.NameNotFoundException ignore) {
        }
    }
}
