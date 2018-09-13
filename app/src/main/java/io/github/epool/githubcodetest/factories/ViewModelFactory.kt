package io.github.epool.githubcodetest.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.github.epool.githubcodetest.repositories.RepositoriesRepository
import io.github.epool.githubcodetest.ui.repositories.RepositoriesViewModel

object ViewModelFactory : ViewModelProvider.Factory {

    private val mRepositoriesRepository = RepositoriesRepository(RetrofitServiceFactory.create())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {

        RepositoriesViewModel::class.java -> RepositoriesViewModel(mRepositoriesRepository)

        else -> throw IllegalArgumentException("No ViewModel registered for $modelClass")

    } as T

}