package kz.nurtbayev.childcare.content.child.add_new_child

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.common.Repository

class CreateChildFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateChildViewModel(repository) as T
    }
}