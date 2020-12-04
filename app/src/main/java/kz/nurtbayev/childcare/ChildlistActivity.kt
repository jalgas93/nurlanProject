package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_childlist.*

class ChildlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_childlist)
        OpenZeroFour()
        OpenSupportActivity()
    }

    private fun OpenZeroFour() {
        zero_four.setOnClickListener {
            val intent = Intent(this, AdviceActivity::class.java)
            startActivity(intent)
        }
    }


    private fun OpenSupportActivity() {
        go_pr_p.setOnClickListener {
            val intent = Intent(this, SupportActivity::class.java)
            startActivity(intent)
        }
    }



}