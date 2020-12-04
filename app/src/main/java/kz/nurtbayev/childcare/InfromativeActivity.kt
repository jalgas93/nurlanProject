package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_infromative.*

class InfromativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infromative)
//        setupViewsCovid()
    }

//    private fun setupViewsCovid() {
//        covid_button.setOnClickListener {
//            val intent = Intent(this, CovidActivity::class.java)
//            startActivity(intent)
//        }
//    }
}