package org.pondar.jetpackexamplekotlin.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val data = MutableLiveData("")

    fun downloadFromServer() {
        if (data.value.isNullOrEmpty())  //do we have data already?
        {
            data.value = "Data is downloaded"
            Log.d("download","download done")
        }
    }

    //called when viewmodel is destroyed
    override fun onCleared() {
        super.onCleared()
        //save data locally
    }
}