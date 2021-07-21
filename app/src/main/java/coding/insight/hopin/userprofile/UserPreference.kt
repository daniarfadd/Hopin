package coding.insight.hopin.userprofile

import android.content.Context

internal class UserPreference(context: Context) {

    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val FINANCIAL = "financial"
        private const val GENDER = "gender"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = preferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phoneNumber)
        editor.putInt(FINANCIAL, value.financial)
        editor.putBoolean(GENDER, value.isGender)
        editor.apply()
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.name = preferences.getString(NAME, "")
        model.email = preferences.getString(EMAIL, "")
        model.age = preferences.getInt(AGE, 0)
        model.financial = preferences.getInt(FINANCIAL, 0)
        model.phoneNumber = preferences.getString(PHONE_NUMBER, "")
        model.isGender = preferences.getBoolean(GENDER, false)

        return model
    }
}
