package coding.insight.hopin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.content.Intent
import android.view.View
import coding.insight.hopin.databinding.ActivityLoginBinding
import coding.insight.hopin.databinding.ActivityProfileEditBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for changing status bar icon colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cirLoginButton.setOnClickListener(this)

    }

    fun onRegisClick(View: View?) {
        startActivity(Intent(this, RegisterActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.cirLoginButton -> {
                val moveIntent = Intent(this, DashboardActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


}