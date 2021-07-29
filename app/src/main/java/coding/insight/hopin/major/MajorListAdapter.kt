package coding.insight.hopin.major

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coding.insight.hopin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MajorListAdapter(private val listMajor: ArrayList<Major>): RecyclerView.Adapter<MajorListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MajorListAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_major, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MajorListAdapter.ListViewHolder, position: Int) {
        val major = listMajor[position]

        Glide.with(holder.itemView.context)
            .load(major.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = major.name
        holder.tvDetail.text = major.detail
    }

    override fun getItemCount(): Int {
        return  listMajor.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }


}