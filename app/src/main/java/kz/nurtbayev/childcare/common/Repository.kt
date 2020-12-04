package kz.nurtbayev.childcare.common

import android.app.Application
import android.content.Context
import kz.nurtbayev.childcare.common.preferences.UserSession
import kz.nurtbayev.childcare.common.remote.ApiConstants
import kz.nurtbayev.childcare.common.remote.Networking
import kz.nurtbayev.childcare.content.child.models.AddNewChildResponse
import kz.nurtbayev.childcare.content.child.models.ChildrenResponse
import kz.nurtbayev.childcare.content.ui.home.models.CategoriesResponse
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalResponse
import retrofit2.Response

class Repository() {
    private val networkService =
        Networking.create(ApiConstants.APP_BASE_URL)

    suspend fun getHospital(): Response<HospitalResponse> {
        return networkService.getOrganizations()
    }

    suspend fun getChildren(): Response<ChildrenResponse> {
        return networkService.getChildren()
    }

    suspend fun createChild(
        birthDate: String,
        disease: String,
        gender: String,
        height: Int,
        id: Int,
        nickname: String,
        parentId: Int,
        weight: Int
    ): Response<AddNewChildResponse> {
        return networkService.createChildren(
            birthDate = birthDate,
            disease = disease,
            gender = gender,
            height = height,
            id = id,
            nickname = nickname,
            parentId = parentId,
            weight = weight
        )
    }

    suspend fun getCategories(): Response<CategoriesResponse> {
        return networkService.getCategories()
    }
}