package coding.insight.hopin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {

    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        lottieAnimationView = findViewById(R.id.lottie)
        var logo = findViewById<TextView>(R.id.hopinlogo)
        var logo1 = findViewById<TextView>(R.id.hopinlogo2)
        lottieAnimationView.animate().translationY(-1600F).setDuration(1000).setStartDelay(3000);
        logo.animate().translationY(-1600F).setDuration(1000).setStartDelay(3000);
        logo1.animate().translationY(-1600F).setDuration(1000).setStartDelay(3000);

//        val moveIntent = Intent(this@SplashActivity, LoginActivity::class.java)
//        startActivity(moveIntent)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}