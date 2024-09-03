package com.example.pinch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.OnScaleGestureListener
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var iv: ImageView
    var scale = 1f
    var ourSD: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv = findViewById(R.id.idImage)
        ourSD = ScaleGestureDetector(this, ScaleListener( ))

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            ourSD?.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }


    inner class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale, 5.0f))
            iv.scaleX = scale
            iv.scaleY = scale
            return true
        }
    }

}