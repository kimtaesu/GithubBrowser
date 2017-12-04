package vingle.hucet.com.vingle.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import vingle.hucet.com.vingle.R
import vingle.hucet.com.vingle.glide.GlideRequests
import vingle.hucet.com.vingle.model.Basic
import vingle.hucet.com.vingle.model.Repo
import vingle.hucet.com.vingle.model.UserInfo
import vingle.hucet.com.vingle.model.ViewType

/**
 * Created by taesu on 2017-12-04.
 */
class GithubAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: ArrayList<Basic> = arrayListOf()

    private var glideRequests: GlideRequests? = null

    fun setGlideRequest(glideRequests: GlideRequests) {
        this.glideRequests = glideRequests
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (item.viewType) {
            ViewType.USER -> {
                item as UserInfo
                holder as UserViewHolder
                holder.name.text = item.login
                glideRequests?.run {
                    load(item.avatar_url)
                            .into(holder.avatar)
                }
            }
            ViewType.REPO -> {
                item as Repo
                holder as RepoViewHolder
                holder.name.text = item.name
                holder.desc.text = item.description
                holder.count.text = "${item.stargazers_count}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                ViewType.USER.type -> {
                    val v = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.list_item_user, parent, false)
                    UserViewHolder(v)
                }
                ViewType.REPO.type -> {
                    val v = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.list_item_repo, parent, false)
                    RepoViewHolder(v)
                }
                else -> {
                    throw IllegalArgumentException()
                }
            }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.user_name)
        val avatar: ImageView = view.findViewById(R.id.user_avatar)
    }

    inner class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.repo_name)
        val desc: TextView = view.findViewById(R.id.repo_desc)
        val count: TextView = view.findViewById(R.id.repo_start_count)
    }

    override fun getItemViewType(position: Int): Int = this.items[position].viewType.type

    override fun getItemCount(): Int = items.size

    fun update(items: List<Basic>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }
}