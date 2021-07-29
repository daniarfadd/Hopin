package coding.insight.hopin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import coding.insight.hopin.databinding.ActivityDashboardBinding
import coding.insight.hopin.databinding.ActivityLoginBinding
import coding.insight.hopin.major.MajorActivity
import coding.insight.hopin.ranknilai.RankNilaiActivity
import coding.insight.hopin.rankuniv.RankGlobalActivity
import coding.insight.hopin.rankuniv.RankIndoActivity
import coding.insight.hopin.rekomen.RekomenActivity

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
        binding.cardViewRank.setOnClickListener(this)
        binding.learnMinat.setOnClickListener(this)
        binding.interestsCard.setOnClickListener(this)
        binding.jurusan.setOnClickListener(this)

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
            R.id.rankNilai -> {
                val moveIntent = Intent(this, RankNilaiActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.rankGlobal -> {
                val moveIntent = Intent(this, RankGlobalActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.cardViewRank -> {
                val moveIntent = Intent(this, RekomenActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.learnMinat -> {
                Toast.makeText(applicationContext,"This feature will be coming soon ", Toast.LENGTH_SHORT).show()
            }
            R.id.interestsCard -> {
                Toast.makeText(applicationContext,"This feature will be coming soon ", Toast.LENGTH_SHORT).show()
            }
            R.id.jurusan -> {
                val moveIntent = Intent (this, MajorActivity::class.java)
                startActivity(moveIntent)
            }

        }
    }
}