package com.usilitel.extractinfofromgithub.uimodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR


/*class Repository(
    var repositoryName: String?,var repositoryOwner: String?,var numberOfStars: Int? ,var hasIssues: Boolean = false
): BaseObservable(){

    @get:Bindable
    var repositoryName : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }

}*/

class Repository(
    repositoryName : String, var repositoryOwner: String?, var numberOfStars: Int?, var hasIssues: Boolean = false
) : BaseObservable(){

    @get:Bindable
    var repositoryName : String = "Habrahabr Android Repository Article"
        set(value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }

}
