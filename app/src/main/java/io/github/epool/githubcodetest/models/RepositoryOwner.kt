package io.github.epool.githubcodetest.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryOwner(
        @SerializedName("id")
        val id: Int,
        @SerializedName("login")
        val login: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
) : Parcelable