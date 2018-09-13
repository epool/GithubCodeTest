package io.github.epool.githubcodetest.repositories

import io.github.epool.githubcodetest.models.Repository
import io.github.epool.githubcodetest.network.RepositoriesApi
import io.reactivex.Flowable

class RepositoriesRepository(private val repositoriesApi: RepositoriesApi) {

    fun searchRepositories(query: String): Flowable<List<Repository>> =
            repositoriesApi.searchRepositories(query)
                    .map { it.items }

}