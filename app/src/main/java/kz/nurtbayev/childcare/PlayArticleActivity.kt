package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play_article.go_pr_p

class PlayArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_article)
        BackAdvicePagefromPlay()
    }

    private fun BackAdvicePagefromPlay() {
        go_pr_p.setOnClickListener {
            val intent = Intent(this, AdviceActivity::class.java)
            startActivity(intent)
        }
    }
}