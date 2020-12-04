package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_survey_second.*

class SurveySecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_second)
        setupViewsSecondSurvey()
        ViewsFillOut()
        ViewsOk()
        BackHomeFromSurveySecond()
    }

    private fun setupViewsSecondSurvey() {
        switch1.setOnClickListener {
            val intent = Intent(this, EmergencyCallActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ViewsFillOut() {
        switch2.setOnClickListener {
            val intent = Intent(this, FilloutActivity::class.java)
            startActivity(intent)
        }
    }


    private fun ViewsOk() {
        switch3.setOnClickListener {
            val intent = Intent(this, OkActivity::class.java)
            startActivity(intent)
        }
    }

    private fun BackHomeFromSurveySecond() {
        go_pr_page3.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }
    }
}