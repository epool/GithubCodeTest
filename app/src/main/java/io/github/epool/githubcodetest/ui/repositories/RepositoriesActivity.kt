package io.github.epool.githubcodetest.ui.repositories

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.github.epool.githubcodetest.R
import io.github.epool.githubcodetest.extensions.getViewModel
import io.github.epool.githubcodetest.ui.repositories.adapter.RepositoriesAdapter
import io.github.epool.githubcodetest.ui.repositorydetail.RepositoryDetailActivityArgs
import kotlinx.android.synthetic.main.activity_repositories.*

class RepositoriesActivity : AppCompatActivity() {

    private lateinit var mViewModel: RepositoriesViewModel
    val mRepositoriesAdapter = RepositoriesAdapter { RepositoryDetailActivityArgs(it).launch(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        setupRecyclerView()

        mViewModel = getViewModel()

        mViewModel.searchRepositories(getRandomQuery()).observe(this, Observer { it?.render(this) })
    }

    private fun setupRecyclerView() = with(repositoriesRecyclerView) {
        layoutManager = LinearLayoutManager(context)
        adapter = mRepositoriesAdapter
    }

    private fun getRandomQuery() = listOf(
            "android", "ios", "react", "java", "kotlin", "javascript", "python", "mobile"
    ).shuffled().first()

}
