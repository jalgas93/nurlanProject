package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.adapter.CovidAdapter
import kz.nurtbayev.childcare.database.Covid


class CovidActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)
//        setupViewstoHome()


        val covidList = listOf<Covid>(
            Covid(
                R.drawable.mothercough,
                R.drawable.favorite,
                "Название",
                "Информация"
            ),

            Covid(
                R.drawable.mothercough,
                R.drawable.favorite,
                "Название",
                "Информация"
            ),

            Covid(
                R.drawable.withcougph,
                R.drawable.favorite,
                "Название",
                "Информация"

            )

        )



        val recyclerView = findViewById<RecyclerView>(R.id._covidRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter =
            CovidAdapter(
                this,
                covidList
            ) {
                val intent = Intent(this, CovidArticleActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
    }
}