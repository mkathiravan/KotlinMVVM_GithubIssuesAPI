package net.kathir.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import net.kathir.myapplication.model.IssueModel
import net.kathir.myapplication.repository.IssueRepository

class IssueViewModel(application: Application) : AndroidViewModel(application)
{
   private val repository = IssueRepository()

    fun getIssuesListDat() : MutableLiveData<List<IssueModel>>?
    {
        return repository.getIssueListData()
    }

}
