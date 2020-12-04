package kz.nurtbayev.childcare.content.ui.likes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.ui.hospitals.HospitalsViewModel

class LikeFactory(val repository: LikesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LikeViewModel(repository) as T
    }
}