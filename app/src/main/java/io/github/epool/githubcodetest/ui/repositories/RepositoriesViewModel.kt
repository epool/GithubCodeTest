package io.github.epool.githubcodetest.ui.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.github.epool.githubcodetest.extensions.toLiveData
import io.github.epool.githubcodetest.repositories.RepositoriesRepository

class RepositoriesViewModel(private val repositoriesRepository: RepositoriesRepository) : ViewModel() {

    fun searchRepositories(query: String): LiveData<RepositoriesViewState> = repositoriesRepository.searchRepositories(query)
            .map { RepositoriesViewState.Success(it) as RepositoriesViewState }
            .startWith(RepositoriesViewState.Loading)
            .onErrorReturn { RepositoriesViewState.Error(it) }
            .cache()
            .toLiveData()

}