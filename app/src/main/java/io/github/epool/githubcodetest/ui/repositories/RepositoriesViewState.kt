package io.github.epool.githubcodetest.ui.repositories

import android.support.design.widget.Snackbar
import android.view.View
import io.github.epool.githubcodetest.models.Repository
import kotlinx.android.synthetic.main.activity_repositories.*

sealed class RepositoriesViewState {

    abstract fun render(activity: RepositoriesActivity)

    object Loading : RepositoriesViewState() {

        override fun render(activity: RepositoriesActivity) {
            activity.progressBar.visibility = View.VISIBLE
        }

    }

    data class Success(val repositories: List<Repository>) : RepositoriesViewState() {

        override fun render(activity: RepositoriesActivity) {
            activity.progressBar.visibility = View.GONE
            activity.mRepositoriesAdapter.submitList(repositories)
        }

    }

    data class Error(val throwable: Throwable) : RepositoriesViewState() {

        override fun render(activity: RepositoriesActivity) {
            throwable.printStackTrace()
            activity.progressBar.visibility = View.GONE
            val rootView = activity.findViewById<View>(android.R.id.content)!!
            Snackbar.make(
                    rootView,
                    throwable.message?.let { it } ?: throwable.toString(),
                    Snackbar.LENGTH_LONG
            ).show()
        }

    }

}