package com.example.a15daystry.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call


class UserViewModel : ViewModel() {

    var list = MutableLiveData<List<EntriesItem>>()

    init {
        viewModelScope.launch {
            list.postValue(getUserApiData()!!.entries as List<EntriesItem>)

        }
    }

    suspend fun getUserApiData(): PublicModel? {
        var apiInterface = ApiClient.getRetrofit()!!.create(ApiInterface::class.java)

        return (withContext(Dispatchers.IO) {
            apiInterface.getdata().body()
        })

    }
}