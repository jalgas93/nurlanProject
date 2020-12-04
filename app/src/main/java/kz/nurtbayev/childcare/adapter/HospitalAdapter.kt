package kz.nurtbayev.childcare.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_hospitals.view.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalData

class HospitalAdapter: RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    var models: List<HospitalData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_hospitals,parent,false)
        return HospitalViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class HospitalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populate(hospitalData: HospitalData){
            itemView.tvNameOrganization.text = hospitalData.name
            itemView.tvInfoOrganization.text = hospitalData.info
//
//            Glide.with(itemView.context).load(hospitalData.icon)
//                .into(itemView.iv_hospital)
        }
    }
}