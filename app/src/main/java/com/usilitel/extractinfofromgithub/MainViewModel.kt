package com.usilitel.extractinfofromgithub

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.usilitel.extractinfofromgithub.uimodels.Repository


/*
class MainViewModel {
    var repoModel: RepoModel = RepoModel()
    var text: String = ""
    var isLoading: Boolean = false

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            //isLoading.set(false)
            isLoading = false
            text.set(data)
        }
    }

    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(onDataReadyCallback)
    }
}*/

class MainViewModel : ViewModel() {

    init{
        println("111")
    }

    var repoModel: RepoModel = RepoModel()
//    val text = ObservableField<String>()
//    val isLoading = ObservableField<Boolean>()
    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = ArrayList<Repository>()

/*    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
                println("222")
            }
        })
    }*/

    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
            }
        })
    }


}