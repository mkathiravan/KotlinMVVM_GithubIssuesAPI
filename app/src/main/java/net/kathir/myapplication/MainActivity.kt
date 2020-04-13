package net.kathir.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.kathir.myapplication.adapter.IssueAdapter
import net.kathir.myapplication.model.IssueModel
import net.kathir.myapplication.viewModel.IssueViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: IssueAdapter

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        adapter = IssueAdapter(this)
        recyclerView?.adapter = adapter
        getIssuesList()
    }

    private fun getIssuesList() {
        val mAndroidViewModel = ViewModelProviders.of(this).get(IssueViewModel::class.java)
        mAndroidViewModel.getIssuesListDat()?.observe(this, Observer<List<IssueModel>>
        {
                issueList ->
            adapter.setIssuesList(issueList)

        })
    }
}
