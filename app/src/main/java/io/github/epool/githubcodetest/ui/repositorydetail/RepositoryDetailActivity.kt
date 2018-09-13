package io.github.epool.githubcodetest.ui.repositorydetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import io.github.epool.githubcodetest.R
import io.github.epool.githubcodetest.models.Repository
import kotlinx.android.synthetic.main.activity_repository_detail.*


class RepositoryDetailActivity : AppCompatActivity() {

    private lateinit var mRepository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)

        mRepository = RepositoryDetailActivityArgs.deserializeFrom(intent).repository

        title = mRepository.name

        setupCarViewClickListener()

        render(mRepository)
    }

    private fun setupCarViewClickListener() {
        repositoryCardView.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setData(Uri.parse(mRepository.svnUrl)).run {
                startActivity(this)
            }
        }
    }

    private fun render(repository: Repository) {
        with(repository) {
            Picasso.get().load(owner.avatarUrl).into(userAvatarImageView)
            repositoryFullName.text = fullName
            repositoryLanguage.text = language
            repositoryStarsCount.text = stargazersCount.toString()
            repositoryDescription.text = description
        }
    }

}
