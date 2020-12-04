package kz.nurtbayev.childcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_likes.view.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleModel

class LikeAdapter: RecyclerView.Adapter<LikeAdapter.LikeViewHolder>() {

    var models: List<ArticleModel> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_likes,parent,false)
        return LikeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class LikeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populate(articleModel: ArticleModel){
            itemView.likesContentTv.text = articleModel.topic
//            itemView.likesTitleTv.text = articleModel.text
        }
    }
}