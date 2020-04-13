package net.kathir.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import net.kathir.myapplication.model.IssueModel
import net.kathir.myapplication.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IssueRepository
{
    private val liveissueRespose: MutableLiveData<List<IssueModel>> = MutableLiveData<List<IssueModel>>()

    fun getIssueListData(): MutableLiveData<List<IssueModel>>?
    {
        val retrofitcall = RetrofitService.create().issueList("square","okhttp")
        retrofitcall.enqueue(object : Callback<List<IssueModel>>
        {
            override fun onFailure(call: Call<List<IssueModel>>, t: Throwable)
            {
                Log.d("ONFAILURE_CALLED ","ONFAILURE_CALLED " + t.message)
            }

            override fun onResponse(call: Call<List<IssueModel>>, response: Response<List<IssueModel>>)
            {
                val list = response.body();
                liveissueRespose.value = list

            }

        }
        )

        return liveissueRespose
    }
}