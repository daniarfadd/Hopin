package coding.insight.hopin.ranknilai

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import coding.insight.hopin.R
import coding.insight.hopin.databinding.ActivityProfileMainBinding
import coding.insight.hopin.databinding.ActivityRankNilaiBinding

class RankNilaiActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private lateinit var binding: ActivityRankNilaiBinding
    var uni = arrayOf("Universitas Indonesia", "Institut Teknologi Bandung", "Universitas Gadjah Mada", "Universitas Brawijaya", "Universitas Andalas")
    var major = arrayOf("Computer Science", "Communications", "Business", "Economics", "Chemical Engineering", "Medical", "Accountancy")
    val NEW_SPINNER_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankNilaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRank.setOnClickListener(this)

        var univ = ArrayAdapter(this, android.R.layout.simple_spinner_item, uni)
        univ.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var majors = ArrayAdapter(this, android.R.layout.simple_spinner_item, major)
        majors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(binding.spinnerMajor)
        {
            adapter = majors
            setSelection(0, false)
            onItemSelectedListener = this@RankNilaiActivity
            prompt = "Select major"
            gravity = Gravity.CENTER

        }

        with(binding.spinnerUni)
        {
            adapter = univ
            setSelection(0, false)
            onItemSelectedListener = this@RankNilaiActivity
            prompt = "Select university"
            gravity = Gravity.CENTER

        }



    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(view?.id){

            R.id.spinner_major -> {
                showToast(message = "Spinner 2 Position:${position} and language: ${major[position]}")
            }

            R.id.spinner_uni -> {
                showToast(message = "Spinner 1 Position:${position} and language: ${uni[position]}")
            }

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }


    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_rank -> {
                binding.tableRank.setVisibility(View.VISIBLE)
            }
        }
    }
}