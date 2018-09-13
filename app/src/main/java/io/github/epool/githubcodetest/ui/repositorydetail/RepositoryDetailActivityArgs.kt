package io.github.epool.githubcodetest.ui.repositorydetail

import android.content.Context
import android.content.Intent
import io.github.epool.githubcodetest.common.ActivityArgs
import io.github.epool.githubcodetest.models.Repository
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryDetailActivityArgs(val repository: Repository) : ActivityArgs {

    override fun intent(context: Context): Intent = Intent(context, RepositoryDetailActivity::class.java)
            .putExtra(EXTRA_KEY, this)

    companion object {

        private const val EXTRA_KEY = "RepositoryDetailActivityArgs"

        fun deserializeFrom(intent: Intent): RepositoryDetailActivityArgs =
                intent.getParcelableExtra(EXTRA_KEY)

    }

}