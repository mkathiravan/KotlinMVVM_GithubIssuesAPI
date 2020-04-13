package net.kathir.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.issue_child.view.*
import net.kathir.myapplication.R
import net.kathir.myapplication.model.IssueModel


class IssueAdapter(var ctx : Context) : RecyclerView.Adapter<IssueAdapter.MyViewHolder>()
{
    private var mList: List<IssueModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(ctx).inflate(R.layout.issue_child,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.issueTitle?.text = mList[position].title
        holder.issueNo?.text = mList[position].number
        holder.issueCreateAt?.text = mList[position].created_at
        holder.issueUser?.text = mList[position].user.login

    }

    fun setIssuesList(items: List<IssueModel>) {
        this.mList = items
        notifyDataSetChanged()
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val issueTitle = view.issue_title
        val issueNo = view.issue_no
        val issueCreateAt = view.issue_createdAt
        val issueUser = view.issue_user

    }

}