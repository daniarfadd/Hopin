package coding.insight.hopin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import coding.insight.hopin.databinding.ActivityDashboardBinding
import coding.insight.hopin.databinding.ActivityPersonalBinding
import coding.insight.hopin.userprofile.ProfileMainActivity

class PersonalActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPersonalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editProfile.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        when(v.id){

            R.id.edit_profile -> {
                val moveIntent = Intent(this, ProfileMainActivity::class.java)
                startActivity(moveIntent)
            }

        }

    }
}