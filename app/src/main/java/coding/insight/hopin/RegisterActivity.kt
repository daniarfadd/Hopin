package coding.insight.hopin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import coding.insight.hopin.databinding.ActivityLoginBinding
import coding.insight.hopin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        changeStatusBarColor()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cirRegisterButton.setOnClickListener(this)

    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //            window.setStatusBarColor(Color.TRANSPARENT);
            window.statusBarColor = resources.getColor(R.color.register_bk_color)
        }
    }

    fun onLoginClick(view: View?) {
        startActivity(Intent(this, LoginActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right)
    }

    override fun onClick(v: View) {
        when(v.id){

            R.id.cirRegisterButton -> {
                val moveIntent = Intent(this, DashboardActivity::class.java)
                startActivity(moveIntent)
            }

        }
    }
}