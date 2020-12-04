package kz.nurtbayev.childcare.content.ui.hospitals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.common.Repository

class HospitalsViewModelFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HospitalsViewModel(repository) as T
    }
}