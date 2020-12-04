package kz.nurtbayev.childcare.common.preferences

import android.content.SharedPreferences

class UserSession(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_ID = "KEY_ID"
        const val KEY_EMAIL = "KEY_EMAIL"
        const val KEY_IS_AUTHORIZE = "KEY_IS_AUTHORIZE"
        const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)
    fun setAccessToken(access_token: String) {
        prefs.edit().putString(KEY_ACCESS_TOKEN, access_token).apply()
    }

    fun getIsAuthorize(): Boolean? = prefs.getBoolean(KEY_IS_AUTHORIZE, false)
    fun setIsAuthorize(isAuthorize: Boolean) {
        prefs.edit().putBoolean(KEY_IS_AUTHORIZE, isAuthorize).apply()
    }

    fun getId(): Int? = prefs.getInt(KEY_ID, 0)
    fun setId(id: Int) {
        prefs.edit().putString(KEY_ID, id.toString()).apply()
    }


    fun getEmail(): String? = prefs.getString(KEY_EMAIL, null)
    fun setEmail(email: String) {
        prefs.edit().putString(KEY_EMAIL, email).apply()
    }


    fun clear() {
        prefs.edit().clear().apply()
    }

}