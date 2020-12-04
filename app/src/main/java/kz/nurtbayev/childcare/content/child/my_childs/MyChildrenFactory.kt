package kz.nurtbayev.childcare.content.child.my_childs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.common.Repository

    class MyChildrenFactory(val repository: Repository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MyChildrenViewModel(repository) as T
    }
}