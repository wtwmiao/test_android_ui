package com.example.huiti123.testchangeparentsize;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by huiti123 on 2017/5/3.
 */

public class MyParentLayoutView extends RelativeLayout implements MyResizeSubView.SubViewSizeChangeDelegate {


    LayoutInflater inflater;

    RelativeLayout mLayout;

    MyResizeSubView subView;


    public MyParentLayoutView(Context context) {
        this(context, null, 0);

    }

    public MyParentLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public MyParentLayoutView(Context context, AttributeSet attrs, int defStlyles) {
        super(context, attrs, defStlyles);

        initView(context);

    }


    public void initView(Context context) {
        inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.my_def_view_layout, this, true);

        mLayout = (RelativeLayout) findViewById(R.id.layout_rootlayout);
        subView = (MyResizeSubView) findViewById(R.id.sub_view);
        subView.setSizeDelegate(this);


    }


    private int dip2px(Context context, int dip) {
        return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
    }

    public void setWidth(int w) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        params.width = dip2px(getContext(), w);
        setLayoutParams(params);
    }

    @Override
    public void onSizeChangeDelegate(int w, int h) {


        setWidth(w);
    }

}
