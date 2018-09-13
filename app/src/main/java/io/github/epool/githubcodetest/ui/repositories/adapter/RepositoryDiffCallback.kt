package io.github.epool.githubcodetest.ui.repositories.adapter

import android.support.v7.util.DiffUtil
import io.github.epool.githubcodetest.models.Repository

class RepositoryDiffCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository) =
            oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository) =
            oldItem == newItem

}