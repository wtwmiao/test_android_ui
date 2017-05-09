package com.example.huiti123.testchangeparentsize.event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by huiti123 on 2017/5/9.
 */

public class EventChildView extends View  implements View.OnClickListener,View.OnTouchListener{

    public EventChildView(Context context) {
        this(context, null, 0);
    }

    public EventChildView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EventChildView(Context context, AttributeSet atttrs, int defStyle) {
        super(context, atttrs, defStyle);

        setOnClickListener(this);
        setOnTouchListener(this);
//
    }

    @Override
    public void onClick(View v) {
        Log.v("EventChildView","sub onClick ");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            Log.v("EventChildView","onTouch ACTION_DOWN");
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

            // Log.v("EventParentView","onTouch ACTION_DOWN");

            // return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.v("EventChildView","onTouch ACTION_UP");

            // return false;
        }


        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("EventChildView","onTouchEvent enter");
        boolean ret =  super.onTouchEvent(event);


        return  ret;
       // return  ret;
    }
}
