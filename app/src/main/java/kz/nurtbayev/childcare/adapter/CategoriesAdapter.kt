package kz.nurtbayev.childcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_categories.view.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.ui.home.models.CategoriesData

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    var models:List<CategoriesData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories,parent,false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populate(categoriesData: CategoriesData){
            itemView.tv_description_categories.text = categoriesData.name
        }
    }
}