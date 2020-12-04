package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupViewsnotification()
        setupViewsOpenBlog()
        setupViewsCovid()
        setupViewsSurvey()
        ViewsYangChildren()
        GoNotificationFHome()
        GoHospitalHome()
        GoInfromativeFHome()


    }

    private fun setupViewsnotification() {
        go_notification_fhome.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewsOpenBlog() {
        go_liked_fhome.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoNotificationFHome() {
        go_notification_fhome.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoHospitalHome() {
        go_hospital_fhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoInfromativeFHome() {
        go_informative_fhome.setOnClickListener {
            val intent = Intent(this, InfromativeActivity::class.java)
            startActivity(intent)
        }
    }






    private fun setupViewsCovid() {
        go_covid_page.setOnClickListener {
            val intent = Intent(this, CovidActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewsSurvey() {
        go_survey_page.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }
    }


    private fun ViewsYangChildren() {
        go_yang_children.setOnClickListener {
            val intent = Intent(this, SupportActivity::class.java)
            startActivity(intent)
        }
    }



}