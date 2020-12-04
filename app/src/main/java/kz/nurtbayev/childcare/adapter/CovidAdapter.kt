package kz.nurtbayev.childcare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.database.Covid
import kz.nurtbayev.childcare.R


class CovidAdapter(
    private val context: Context,
    private val covids: List<Covid>,
    val listenercovid: (Covid) -> Unit
) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {
    class CovidViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val covid_Src = view.findViewById<ImageView>(R.id.covid_image)
        val covid_Title = view.findViewById<TextView>(R.id.covid_title)
        val covid_Like = view.findViewById<ImageView>(R.id.covid_like)
        val covid_Desc = view.findViewById<TextView>(R.id.covid_description)

        fun bindView(covid: Covid, listenercovid: (Covid) -> Unit) {
            covid_Src.setImageResource(covid.covidSrc)
            covid_Title.text = covid.covidTitle
            covid_Like.setImageResource(covid.covidLike)
            covid_Desc.text = covid.covidDesc

            itemView.setOnClickListener { listenercovid(covid) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder =
        CovidViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.covid_recycler_view,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = covids.size

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        holder.bindView(covids[position], listenercovid)
    }
}