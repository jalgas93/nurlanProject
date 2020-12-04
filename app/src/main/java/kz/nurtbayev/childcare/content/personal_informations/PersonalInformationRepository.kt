package kz.nurtbayev.childcare.content.personal_informations

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import kz.nurtbayev.childcare.common.preferences.UserSession
import kz.nurtbayev.childcare.common.remote.ApiConstants
import kz.nurtbayev.childcare.common.remote.Networking
import kz.nurtbayev.childcare.content.personal_informations.models.CityModel
import kz.nurtbayev.childcare.content.personal_informations.models.OrganizationsModel
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalData

class PersonalInformationRepository(application: Application) {

    companion object {
        const val TAG = "PersonalInformationRepository"
    }

    private val networkService =
            Networking.create(ApiConstants.APP_BASE_URL)
    private var sharedPreferences =
            application.getSharedPreferences("userSession", Context.MODE_PRIVATE)
    private var userSession: UserSession =
            UserSession(sharedPreferences)

    @SuppressLint("LongLogTag")
    suspend fun getCities(): List<CityModel>? {
        val cities = networkService.getCities()
        return if (cities.code()==200){
            cities.body()?.data
        } else null
    }

    @SuppressLint("LongLogTag")
    suspend fun getOrganizations(): List<HospitalData>? {
        val organizations = networkService.getOrganizations()
        return if (organizations.code()==200){
            organizations.body()?.data
        } else null
    }



}

