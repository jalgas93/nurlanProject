package kz.nurtbayev.childcare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.database.Image
import kz.nurtbayev.childcare.R

class ImageAdapter(
    private val context: Context,
    private val images: List<Image>,
    val listener: (Image) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageSrc = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.hospital_title)
        val imageLoc = view.findViewById<ImageView>(R.id.hospital_location)
        val description = view.findViewById<TextView>(R.id.hospital_description)
        val address = view.findViewById<TextView>(R.id.hospital_address)
        fun bindView(image: Image, listener: (Image) -> Unit) {
            imageSrc.setImageResource(image.hospitalSrc)
            title.text = image.hospitalTitle
            imageLoc.setImageResource(image.hospitaLoc)
            description.text = image.hospitalDesc
            address.text = image.hospitalAddress
            itemView.setOnClickListener { listener(image) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_image,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}