package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fillout.*

class FilloutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fillout)
        BackfromFillout()
    }

    private fun BackfromFillout() {
        ok_fill_out.setOnClickListener {
            val intent = Intent(this, SurveySecondActivity::class.java)
            startActivity(intent)
        }
    }
}