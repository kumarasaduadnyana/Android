package com.android.usergithub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.usergithub.ListData
import com.android.usergithub.UserList
import com.android.usergithub.api.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    val userList = MutableLiveData<ArrayList<UserList>>()

    fun setUserSearch(q:String) {
        RetrofitObject.instanceApi
            .searchUserList(q)
            .enqueue(object : Callback<ListData>{
                override fun onResponse(call: Call<ListData>, response: Response<ListData>) {
                    while (response.isSuccessful){
                        userList.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<ListData>, t: Throwable) {
                    t.message?.let { Log.d("Eror", it) }
                }

            })
    }

    fun getUserSearch() : LiveData<ArrayList<UserList>> {
        return userList
    }
}