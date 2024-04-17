package com.example.lectoapp.util

import android.content.Context
import android.net.Uri
import androidx.annotation.RawRes

fun @receiver:RawRes Int.toUri(context: Context): Uri {
    return Uri.parse("android.resource://" + context.packageName + "/" + this)
}