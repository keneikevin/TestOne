package com.example.testone.domain.mappers

import android.os.Parcelable
import com.example.testone.data.local.entity.Thumbnaill

import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class CharacterInfo(
    val title:String,
    val description: String?,
    val thumbnaill:@RawValue Thumbnaill?
): Parcelable