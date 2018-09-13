package io.github.epool.githubcodetest.ui.repositories.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.github.epool.githubcodetest.R
import io.github.epool.githubcodetest.models.Repository
import kotlinx.android.synthetic.main.item_repository_row.view.*

class RepositoriesAdapter(
        private val onClickListener: (Repository) -> Unit
) : ListAdapter<Repository, RepositoriesAdapter.ViewHolder>(RepositoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository_row, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(getItem(position), onClickListener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repository: Repository, clickListener: (Repository) -> Unit) = with(repository) {
            Picasso.get().load(owner.avatarUrl).into(itemView.userAvatarImageView)
            itemView.repositoryFullName.text = fullName
            itemView.repositoryLanguage.text = language
            itemView.repositoryStarsCount.text = stargazersCount.toString()
            itemView.setOnClickListener { clickListener(this) }
        }

    }

}