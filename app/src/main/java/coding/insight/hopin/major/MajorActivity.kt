package coding.insight.hopin.major

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coding.insight.hopin.R
import coding.insight.hopin.databinding.ActivityDashboardBinding
import coding.insight.hopin.databinding.ActivityMajorBinding

class MajorActivity : AppCompatActivity() {

    private lateinit var rvMajor: RecyclerView
    private lateinit var binding: ActivityMajorBinding

    private var list: ArrayList<Major> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMajorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvMajor = binding.rvHeroes
        rvMajor.setHasFixedSize(true)

        list.addAll(MajorData.listData)
        showRecylerList()
    }

    private fun showRecylerList() {
        rvMajor.layoutManager = LinearLayoutManager(this)
        val listMajorAdapter = MajorListAdapter(list)
        rvMajor.adapter = listMajorAdapter
    }

}