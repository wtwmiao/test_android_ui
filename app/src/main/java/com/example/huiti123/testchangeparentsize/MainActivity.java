package com.example.huiti123.testchangeparentsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btn  ;

    MyParentLayoutView myview;

    public  int times  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn= (Button) findViewById(R.id.my_button);
        btn.setOnClickListener(this);

        myview = (MyParentLayoutView) findViewById(R.id.my_layout_view);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.my_button){

            times ++;
            myview.setWidth(34 + times *2);
        }
    }
}
