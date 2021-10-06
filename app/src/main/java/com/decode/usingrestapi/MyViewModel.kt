package com.decode.usingrestapi

import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import com.decode.usingrestapi.helpers.RetrofiBuilder
import com.decode.usingrestapi.interfaces.ApiService
import com.decode.usingrestapi.repositories.DogResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create
import retrofit2.http.Query

class MyViewModel: ViewModel() {

    var dataList = mutableListOf<String>()

    fun getAll(){

    }

    fun searchByBreed(query:String): MutableList<String> {
        lateinit var dogs: DogResponse

      CoroutineScope(Dispatchers.IO).launch {
          val call= RetrofiBuilder.getRetrofit().create(ApiService::class.java).getByBreed(
            "$query/images"
          )
          if(call.isSuccessful){
              dataList.clear()
              dogs= call.body()!!
              Log.d("dogs", dogs.images[1])
              dataList.addAll(dogs.images)
          }else{
              Log.d("call",call.message())
          }
      }
        return dataList
    }


}