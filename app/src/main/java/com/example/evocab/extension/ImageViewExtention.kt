package com.example.evocab.extension

import android.net.Uri
import android.widget.ImageView
import com.example.evocab.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

fun ImageView.loadImage(uri : Uri) {
    Picasso
        .get()
        .load(uri)
        .placeholder(R.drawable.img_home_family)
        .error(R.drawable.img_home_family)
        .into(this)
}

//fun CircleImageView.loadImage(uri: Uri) {
//    Picasso
//        .get()
//        .load(uri)
//        .resize(Constant.SIZE_DEFAULT_IMAGE, Constant.SIZE_DEFAULT_IMAGE)
//        .centerCrop()
//        .placeholder(R.drawable.img_home_family)
//        .error(R.drawable.img_home_family)
//        .into(this)
//}
