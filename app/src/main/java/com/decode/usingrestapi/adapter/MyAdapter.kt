package com.decode.usingrestapi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.decode.usingrestapi.R
import com.decode.usingrestapi.databinding.LayoutAdapterBinding
import com.decode.usingrestapi.repositories.DogResponse
import com.squareup.picasso.Picasso

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    var dogsList= mutableListOf<String>()
    fun setListData(dogsData:MutableList<String> ){
        dogsList = dogsData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var imageUrl= dogsList[position]
        Log.d("adap",imageUrl)
        holder.bindingData(imageUrl)
    }

    override fun getItemCount(): Int {
      return dogsList.size
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    var binding = LayoutAdapterBinding.bind(view)
        fun bindingData(imgeUrl: String){
           Picasso.get().load(imgeUrl).into(binding.imageView)
        }
    }
}