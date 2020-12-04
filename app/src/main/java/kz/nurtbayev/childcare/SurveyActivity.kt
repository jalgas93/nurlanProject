package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_survey.*

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        setupViewsSecondSurvey()
        BackHomeFromSurvey()
        LikedFSurvey()
        HomeFSurvey()
        NotificationFSurvey()
        HospitalFSurvey()
    }

    private fun setupViewsSecondSurvey() {
        go_second_survey.setOnClickListener {
            val intent = Intent(this, SurveySecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun BackHomeFromSurvey() {
        go_pr_page2.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun HomeFSurvey() {
        go_home_fsurvey.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun NotificationFSurvey() {
        go_notification_fsurvey.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun HospitalFSurvey() {
        go_hospital_fsurvey.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun LikedFSurvey() {
        go_liked_fsurvey.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }
    }


}