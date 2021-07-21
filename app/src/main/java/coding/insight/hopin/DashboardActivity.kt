package coding.insight.hopin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import coding.insight.hopin.databinding.ActivityDashboardBinding
import coding.insight.hopin.databinding.ActivityLoginBinding
import coding.insight.hopin.ranknilai.RankNilaiActivity
import coding.insight.hopin.rankuniv.RankGlobalActivity
import coding.insight.hopin.rankuniv.RankIndoActivity

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPersonal.setOnClickListener(this)
        binding.rankIndo.setOnClickListener(this)
        binding.rankGlobal.setOnClickListener(this)
        binding.rankNilai.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_personal -> {
                val moveIntent = Intent(this,PersonalActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.rankIndo -> {
                val moveIntent = Intent(this, RankIndoActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.rankGlobal -> {
                val moveIntent = Intent(this, RankGlobalActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.rankNilai -> {
                val moveIntent = Intent(this, RankNilaiActivity::class.java)
                startActivity(moveIntent)
            }

        }
    }
}