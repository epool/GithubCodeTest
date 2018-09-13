package io.github.epool.githubcodetest.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("language")
        val language: String,
        @SerializedName("stargazers_count")
        val stargazersCount: Int,
        @SerializedName("svn_url")
        val svnUrl: String,
        @SerializedName("owner")
        val owner: RepositoryOwner
) : Parcelable