package com.example.gesturetestkotlin

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    lateinit var gestureDetector: GestureDetector
     var  x2:Float = 0.0f
     var  x1:Float = 0.0f
     var  y1:Float = 0.0f
     var  y2:Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gestureDetector = GestureDetector(this, this)


    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        gestureDetector.onTouchEvent(event)

        when (event?.action) {

            0 ->
            {
                x1 = event.x
                y1 = event.y
            }

            1 ->
            {
                x2 = event.x
                y2 = event.y

                val valueX:Float = x2 -x1
                val valueY:Float = y2 - y1


                if (abs(valueX) > MIN_DISTANCE)
                {
                    if (x2 > x1)
                    {
                        Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
                    }
                    
                    else
                    {
                        Toast.makeText(this, "Left swipe", Toast.LENGTH_SHORT).show()
                    }



                }
                else if (abs(valueY) > MIN_DISTANCE)
                //detect top to bottom swipe
                    if (y2 > y1) {
                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
                    } else { //detect bottom to top swipe
                        Toast.makeText(this, "Top swipe", Toast.LENGTH_SHORT).show()
                    }

            }
        }



        return super.onTouchEvent(event)
    }



     companion object {
         const val MIN_DISTANCE = 150
     }

    override fun onShowPress(e: MotionEvent?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return false

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return false

    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return false

    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
