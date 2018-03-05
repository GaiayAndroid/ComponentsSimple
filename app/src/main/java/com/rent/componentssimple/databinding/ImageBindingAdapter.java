package com.rent.componentssimple.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.rent.componentssimple.glide.GlideApp;
import com.rent.componentssimple.glide.GlideRequest;

/**
 * <p> Created by RenTao on 2018/2/7.
 */
public class ImageBindingAdapter {
//    @BindingAdapter(value = { "imageUrl", "placeholder", "roundAsCircle" }, requireAll = false)
//    public static void setImage(ImageView view, String url, Drawable placeholder, boolean roundAsCircle) {
//        GlideRequest glideRequest = GlideApp.with(view.getContext()).load(url).placeholder(placeholder);
//        if (roundAsCircle) {
//            glideRequest = glideRequest.circleCrop();
//        }
//        glideRequest.into(view);
//
//    }

    @BindingAdapter(value = { "imageUrl", "placeholder" }, requireAll = false)
    public static void setImage(ImageView view, String url, Drawable drawable) {
        GlideApp.with(view.getContext()).load(url).placeholder(drawable).into(view);
    }
}

