package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ok.*

class OkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok)
        ToSurveytwo()
    }

    private fun ToSurveytwo() {
        ok_page.setOnClickListener {
            val intent = Intent(this, SurveySecondActivity::class.java)
            startActivity(intent)
        }
    }
}