package com.android.usergithub

import com.google.gson.annotations.SerializedName


data class ListData(
    @SerializedName("items")
    var items : ArrayList<UserList>
)
