package kz.nurtbayev.childcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_category.view.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleCategory

class HorizontalAdapter: RecyclerView.Adapter<HorizontalAdapter.HorizontalVIewHolder>() {

    var models:List<ArticleCategory> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalVIewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_article_category,parent,false)
        return HorizontalVIewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: HorizontalVIewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class HorizontalVIewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populate(articleCategory: ArticleCategory){
            itemView.tv_description_article_categories.text = articleCategory.name
            Glide.with(itemView.context).load(articleCategory.icon)
                .into(itemView.iv_article_categories)
        }
    }
}