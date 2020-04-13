package net.kathir.myapplication.apiInterface

import net.kathir.myapplication.model.IssueModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/repos/{ownername}/{repo}/issues")
    fun issueList(@Path("ownername") id: String, @Path("repo") repo: String) : Call<List<IssueModel>>

}