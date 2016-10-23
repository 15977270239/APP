package com.www.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.www.app.R;
import com.www.app.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bin on 2016/10/23.
 * 启动界面Activity
 *  class desc: 启动画面 (1)判断是否是首次加载应用--采取读取SharedPreferences的方法
 *  2)是，则进入GuideActivity；否，则进入MainActivity (3)3s后执行(2)操作
 */

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViews();
        initDots();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        // 初始化引导图片列表
        views.add(inflater.inflate(R.layout.activity_start_one, null));
        views.add(inflater.inflate(R.layout.activity_start_two, null));
        views.add(inflater.inflate(R.layout.activity_start_three, null));
        // 初始化Adapter
        vpAdapter = new ViewPagerAdapter(views,this);
        vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        vp.setOnPageChangeListener(this);
    }
    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[views.size()];
        //循环获取小点图片
        for (int i = 0; i < views.size(); i++){
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);//都设为灰色
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
    }
    private void setCurrentDot(int position) {
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }

        dots[position].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = position;
    }
    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
        setCurrentDot(position);
    }
    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
