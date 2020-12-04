package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.adapter.ImageAdapter
import kz.nurtbayev.childcare.database.Image
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private fun setupViewstoHome() {
        rec_home_button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewstoHome()


        val imageList = listOf<Image>(
            Image(
                R.drawable.hospital1,
                R.drawable.location,
                "Название",
                "Информация",
                "Алматы, Казахстан",
                "87077690754",
                "Онкоцентр",
                "Услуга",
                "4000тг"
            ),

            Image(
                R.drawable.hospital2,
                R.drawable.location,
                "Название",
                "Информация",
                "Алматы, Казахстан",
                "87077690754",
                "Кардиоцентр",
                "Услуга",
                "6000тг"
            ),

            Image(
                R.drawable.hospital3,
                R.drawable.location,
                "Название",
                "Информация",
                "Алматы, Казахстан",
                "87077690754",
                "Институт нейрохирургий",
                "Услуга",
                "7000тг"
            )

        )



        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter =
            ImageAdapter(
                this,
                imageList
            ) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
    }
}
