package io.github.epool.githubcodetest.network

import io.github.epool.githubcodetest.models.helpers.GetRepositoriesResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesApi {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String): Flowable<GetRepositoriesResponse>

}