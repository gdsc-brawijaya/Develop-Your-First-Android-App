package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commitNow
import com.gdsc.gdscubworkshopandroid1.R

class PredictionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        supportFragmentManager.commitNow(allowStateLoss = true) {
            add(R.id.predict_container, PredictionFragment(), PredictionFragment::class.java.simpleName)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}