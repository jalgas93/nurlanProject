package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_emotion_article.*

class EmotionArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion_article)
        BackAdvicePage()
    }

    private fun BackAdvicePage() {
        go_pr_page1.setOnClickListener {
            val intent = Intent(this, AdviceActivity::class.java)
            startActivity(intent)
        }
    }
}