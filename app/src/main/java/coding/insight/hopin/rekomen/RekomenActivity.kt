package coding.insight.hopin.rekomen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import coding.insight.hopin.R
import coding.insight.hopin.databinding.ActivityRankNilaiBinding
import coding.insight.hopin.databinding.ActivityRekomenBinding

class RekomenActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private lateinit var binding: ActivityRekomenBinding
    var minat = arrayOf("economy", "biology", "chemistry", "physics", "mathematics", "languages", "sociology", "computers", "geography", "arts", "history")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekomen)
        binding = ActivityRekomenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var interest = ArrayAdapter(this, android.R.layout.simple_spinner_item, minat)
        interest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.rekomenBtn.setOnClickListener(this)

        with(binding.spinnerMinat)
        {
            adapter = interest
            setSelection(0, false)
            onItemSelectedListener = this@RekomenActivity
            prompt = "Select Interest"
            gravity = android.view.Gravity.CENTER

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(view?.id){

            R.id.spinner_minat -> {
                showToast(message = minat[position])
            }
        }
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.rekomen_btn -> {
                val moveIntent = Intent(this, ResultRekomenActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}