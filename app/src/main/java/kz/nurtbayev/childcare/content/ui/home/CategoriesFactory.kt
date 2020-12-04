package kz.nurtbayev.childcare.content.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.ui.hospitals.HospitalsViewModel


class CategoriesFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoriesVIewModel(repository) as T
    }
}