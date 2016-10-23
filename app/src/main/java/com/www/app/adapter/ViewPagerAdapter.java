package com.www.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.www.app.MainActivity;
import com.www.app.R;

import java.util.List;

/**
 * Created by Bin on 2016/10/23.
 * 引导页Adapter
 */

public class ViewPagerAdapter extends PagerAdapter {
    //界面列表
    private List<View> views;
    private Activity activity;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    public ViewPagerAdapter(List<View> views,Activity activity){
        this.views=views;
        this.activity=activity;
    }
    //销毁arg1位置的界面


    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public void finishUpdate(View container) {
        super.finishUpdate(container);
    }
    //获得当前界面数
    @Override
    public int getCount() {
        if (views != null){
            return  views.size();
        }
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(views.get(position),0);
        if (position == views.size() - 1) {
			Button mStartWeiboImageButton = (Button) container
					.findViewById(R.id.start_ac);
			mStartWeiboImageButton.setOnTouchListener(mListener);

			mStartWeiboImageButton.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// 设置已经引导
					setGuided();
					goHome();

				}

			});

        }
        return views.get(position);
    }

    public View.OnTouchListener mListener=new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // 设置已经引导
                    setGuided();
                    goHome();
                    break;

                default:
                    break;
            }
            return true;
        }
    };

    private void goHome() {
        // 跳转
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     *
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SharedPreferences preferences = activity.getSharedPreferences(
                SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // 存入数据
        editor.putBoolean("isFirstIn", false);
        // 提交修改
        editor.commit();
    }
    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}
