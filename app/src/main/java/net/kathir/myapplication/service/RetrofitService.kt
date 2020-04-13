package net.kathir.myapplication.service

import android.util.Log
import com.google.gson.GsonBuilder
import net.kathir.myapplication.apiInterface.ApiInterface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService
{
    companion object Factory
    {
        var gson = GsonBuilder().setLenient().create()

        fun create() : ApiInterface
        {
            Log.d("retrofit","create")

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com").build()

            return retrofit.create(ApiInterface::class.java)
        }
    }


}