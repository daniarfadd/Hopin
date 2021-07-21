package coding.insight.hopin.userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import coding.insight.hopin.R
import coding.insight.hopin.databinding.ActivityProfileMainBinding

class ProfileMainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserPreference: UserPreference
    private lateinit var binding: ActivityProfileMainBinding

    private var isPreferenceEmpty = false
    private lateinit var userModel: UserModel

    companion object {
        private const val REQUEST_CODE = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Profile"

        mUserPreference = UserPreference(this)

        showExistingPreference()

        binding.btnSave.setOnClickListener(this)
    }

    private fun showExistingPreference() {
        userModel = mUserPreference.getUser()
        populateView(userModel)
        checkForm(userModel)
    }

    private fun populateView(userModel: UserModel) {
        binding.tvName.text = if (userModel.name.toString().isEmpty()) "None" else userModel.name
        binding.tvAge.text = if (userModel.age.toString().isEmpty()) "None" else userModel.age.toString()
        binding.tvFinancial.text = if (userModel.financial.toString().isEmpty()) "None" else userModel.financial.toString()
        binding.tvGender.text = if (userModel.isGender) "Female" else "Male"
        binding.tvEmail.text = if (userModel.email.toString().isEmpty()) "None" else userModel.email
        binding.tvPhone.text = if (userModel.phoneNumber.toString().isEmpty()) "None" else userModel.phoneNumber
    }

    private fun checkForm(userModel: UserModel) {
        when {
            userModel.name.toString().isNotEmpty() -> {
                binding.btnSave.text = getString(R.string.change)
                isPreferenceEmpty = false
            }
            else -> {
                binding.btnSave.text = getString(R.string.change)
                isPreferenceEmpty = true
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            val intent = Intent(this, ProfileEditActivity::class.java)
            when {
                isPreferenceEmpty -> {
                    intent.putExtra(ProfileEditActivity.EXTRA_TYPE_FORM, ProfileEditActivity.TYPE_ADD)
                    intent.putExtra("USER", userModel)
                }
                else -> {
                    intent.putExtra(ProfileEditActivity.EXTRA_TYPE_FORM, ProfileEditActivity.TYPE_EDIT)
                    intent.putExtra("USER", userModel)
                }
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == ProfileEditActivity.RESULT_CODE) {
                userModel = data?.getParcelableExtra<UserModel>(ProfileEditActivity.EXTRA_RESULT) as UserModel
                populateView(userModel)
                checkForm(userModel)
            }
        }
    }


}