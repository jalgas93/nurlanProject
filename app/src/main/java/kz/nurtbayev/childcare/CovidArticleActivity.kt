package kz.nurtbayev.childcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kz.nurtbayev.childcare.database.Image

class CovidArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_covid_article)

        val image = intent.getParcelableExtra<Image>(MainActivity.INTENT_PARCELABLE)

        val covSrc = findViewById<ImageView>(R.id.cov_image)
        val covTitle = findViewById<TextView>(R.id.cov_name)
        val covDesc = findViewById<TextView>(R.id.cov_des)

        covSrc.setImageResource(image.hospitalSrc)
        covTitle.text = image.hospitalTitle
        covDesc.text = image.hospitalAddress
    }
}