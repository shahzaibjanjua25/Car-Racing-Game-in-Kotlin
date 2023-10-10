package com.example.carracinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.ButtonBarLayout

class MainActivity : AppCompatActivity(),TaskLogic {
    lateinit var rootlayout:LinearLayout
    lateinit var startBtn:Button
    lateinit var mGameView:ViewLogic
    lateinit var score: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn=findViewById(R.id.StartBtn)
        rootlayout=findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView= ViewLogic(this,this)

        startBtn.setOnClickListener({
            mGameView.setBackgroundResource(R.drawable.road2)
            rootlayout.addView(mGameView)
            startBtn.visibility= View.GONE
            score.visibility=View.GONE


        })
    }

    override fun closeGame(mscore: Int) {
        score.text="Score:$mscore"
        rootlayout.removeView((mGameView))
        startBtn.visibility=View.VISIBLE
        score.visibility=View.VISIBLE
    }
}