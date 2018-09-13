package io.github.epool.githubcodetest.models.helpers

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.github.epool.githubcodetest.models.Repository
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetRepositoriesResponse(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("incomplete_results")
        val incompleteResults: Boolean,
        @SerializedName("items")
        val items: List<Repository>
) : Parcelable