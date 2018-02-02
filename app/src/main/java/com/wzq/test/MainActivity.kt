package com.wzq.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.activity_launcher.*


/**
 * Created by wzq on 2018/1/31.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        b1.setOnClickListener {
            go(Intent(this, GridExampleActivity::class.java))
        }

        b2.setOnClickListener {
            go(Intent(this, CardExampleActivity::class.java))
        }

        b3.setOnClickListener { startActivity(Intent(this, SwapActivity::class.java)) }
    }

    private fun go(intent: Intent ) {
        val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent, bundle)
    }
}