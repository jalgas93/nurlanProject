package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kz.nurtbayev.childcare.database.Image
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = intent.getParcelableExtra<Image>(MainActivity.INTENT_PARCELABLE)

        val imgSrc = findViewById<ImageView>(R.id.hos_image)
        val imgTitle = findViewById<TextView>(R.id.hos_name)
        val imgDesc = findViewById<TextView>(R.id.hos_address)

        imgSrc.setImageResource(image.hospitalSrc)
        imgTitle.text = image.hospitalTitle
        imgDesc.text = image.hospitalAddress

        setupViewshome()
        BackHomefromDetail()
        BackNotificationfromDetail()
        BacklikedfromDetail()



    }

    private fun setupViewshome() {
        usluga_button.setOnClickListener {
            val intent = Intent(this, UslugaActivity::class.java)
            startActivity(intent)
        }
    }


   private fun BackHomefromDetail() {
        go_home_fchosdetail.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun BackNotificationfromDetail() {
        go_notification_fchosdetail.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

    }

    private fun BacklikedfromDetail() {
        go_liked_fchosdetail.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }

    }
}
