package com.usilitel.extractinfofromgithub

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.usilitel.extractinfofromgithub.databinding.ActivityMainBinding
import com.usilitel.extractinfofromgithub.uimodels.Repository

class MainActivity : AppCompatActivity() {

/*
https://habr.com/ru/post/341602/
извлекает все репозитории пользователя googlesamples из GitHub,
сохраняет эти данные в локальной базе данных и показывает их пользователю.
https://github.com/googlesamples
*/

    lateinit var binding: ActivityMainBinding

    //var mainViewModel = MainViewModel()

//    var repository = Repository(
//        "Habrahabr Android Repository Article","Fleka", 1000, true
//    )

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //binding.repositoryName.text = "Modern Android Habrahabr Article"
//        binding.apply {
//            repositoryName.text = "Medium Android Repository Article"
//            repositoryOwner.text = "Fleka"
//            numberOfStarts.text = "1000 stars"
//        }

        binding.repository = repository
        binding.executePendingBindings()

        Handler().postDelayed({
            repository.repositoryName="New Name"
            //binding.repository = repository
            //binding.executePendingBindings()

        }, 2000)

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.executePendingBindings()

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.viewModel = mainViewModel
//        binding.executePendingBindings()

    }
}
