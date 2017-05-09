package com.example.huiti123.testchangeparentsize.event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.huiti123.testchangeparentsize.R;

/**
 * Created by huiti123 on 2017/5/9.
 */

public class EventParentView extends RelativeLayout implements View.OnTouchListener{


    public EventParentView(Context context) {
        this(context, null, 0);

    }

    public EventParentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public EventParentView(Context context, AttributeSet attrs, int defStlyles) {
        super(context, attrs, defStlyles);

        initView(context);
    }


    public void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_event_parent, this, true);

        this.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            Log.v("EventParentView","onTouch ACTION_DOWN");
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

           // Log.v("EventParentView","onTouch ACTION_DOWN");

           // return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.v("EventParentView","onTouch ACTION_UP");

           // return false;
        }


        return false;
    }
}
