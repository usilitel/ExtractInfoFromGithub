package com.usilitel.extractinfofromgithub

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.usilitel.extractinfofromgithub.databinding.ActivityMainBinding
import com.usilitel.extractinfofromgithub.uimodels.Repository

class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {
//class MainActivity : LifecycleActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {
/*
https://habr.com/ru/post/341602/
извлекает все репозитории пользователя googlesamples из GitHub,
сохраняет эти данные в локальной базе данных и показывает их пользователю.
https://github.com/googlesamples
*/

/*    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = RepositoryRecyclerViewAdapter(viewModel.repositories.value, this)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.viewModel = mainViewModel
//        binding.executePendingBindings()

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    private lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
            Observer<ArrayList<Repository>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
