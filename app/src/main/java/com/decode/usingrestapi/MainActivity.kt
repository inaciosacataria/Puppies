package com.decode.usingrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decode.usingrestapi.adapter.MyAdapter
import com.decode.usingrestapi.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener{

    var adapter= MyAdapter()
    val viewModel:MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView ()
        binding.searchView.setOnQueryTextListener(this)
    }

    fun initRecyclerView (){

        binding.rcvImages.layoutManager = GridLayoutManager(this,2)
        binding.rcvImages.setHasFixedSize(true)
        binding.rcvImages.adapter= adapter
    }

    fun bindinData(query: String){
       var list= viewModel.searchByBreed(query)
       adapter.setListData(list)
        adapter.notifyDataSetChanged()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        if (!query.isNullOrEmpty()){
            var list = viewModel.searchByBreed(query)
            adapter.setListData(list)

            adapter.notifyDataSetChanged()
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}