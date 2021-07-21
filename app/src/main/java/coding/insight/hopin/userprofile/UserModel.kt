package coding.insight.hopin.userprofile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel (
    var name: String? = null,
    var email: String? = null,
    var age: Int = 0,
    var phoneNumber: String? = null,
    var financial: Int = 0,
    var isGender: Boolean = false
) : Parcelable