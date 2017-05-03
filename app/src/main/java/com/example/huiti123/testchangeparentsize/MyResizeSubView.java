package com.example.huiti123.testchangeparentsize;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by huiti123 on 2017/5/3.
 */

public class MyResizeSubView extends View {

    private AsyncTask mCurrentTask;

    private  SubViewSizeChangeDelegate sizeDelegate;

    private  final  String TAG = "MyResizeSubView";



    public MyResizeSubView(Context context) {
        this(context, null,0);
    }

    public MyResizeSubView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyResizeSubView(Context context, AttributeSet atttrs, int defStyle){
        super(context,atttrs,defStyle);

        startResizeTask();

    }

    public void setSizeDelegate(SubViewSizeChangeDelegate sizeDelegate) {
        this.sizeDelegate = sizeDelegate;
    }


    interface SubViewSizeChangeDelegate{

        void onSizeChangeDelegate(int w,int h);

    }

    public void startResizeTask() {

        mCurrentTask = new AsyncTask() {

            int testcout = 0;

            @Override
            protected Object doInBackground(Object[] params) {
                int i = 0;
                for (i = 0; i <= 100; i++) {
                    publishProgress(i); // 将会调用onProgressUpdate方法
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                /// super.onProgressUpdate(values);

                if (sizeDelegate != null) {
                    testcout++;
                    sizeDelegate.onSizeChangeDelegate(20 + testcout * 10, 10);
                }
            }
        };

        if (android.os.Build.VERSION.SDK_INT >= 11) {
            mCurrentTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
        } else {
            mCurrentTask.execute(null, null, null);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.i(TAG, "cur width = "+widthSize+"cur height = " + heightSize);


    }
}
