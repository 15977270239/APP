package com.www.app;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

import com.www.app.dao.BaseFramActivity;
import com.www.app.fragment.MeFragment;
import com.www.app.fragment.PinFragment;
import com.www.app.fragment.QiangFragment;
import com.www.app.fragment.WanFragment;
import com.www.app.fragment.ZhiBoFragment;
import com.www.app.network.MQuery;
import com.www.app.utils.ClickLimit;
import com.www.app.utils.T;


public class MainActivity extends BaseFramActivity{
    MQuery mq;
    private static FragmentManager fmanger;
    private Fragment[] fragments;
    private int[] tabIds = {R.id.tab_home,R.id.tab_group,
    R.id.tab_direct,R.id.tab_options,R.id.tab_me};
    private static RadioButton[] radioBtns;
    public static boolean back = true;
    private boolean initdone;
    FragmentTransaction framtran;
    @Override
    public void createActivity(Bundle savedInstanceState) {
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        setContentView(R.layout.activity_main);
        String[] mPermissionList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS};
        ActivityCompat.requestPermissions(MainActivity.this, mPermissionList, 100);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        fmanger = getSupportFragmentManager();
        fragments = new Fragment[5];
        fragments[0] = new QiangFragment();
        fragments[1] = new PinFragment();
        fragments[2] = new ZhiBoFragment();
        fragments[3] = new WanFragment();
        fragments[4] = new MeFragment();
        radioBtns = new RadioButton[tabIds.length];
        FragmentTransaction ft = fmanger.beginTransaction();
        ft.add(R.id.framelayout,fragments[0],"0");
        for (int i = 0; i < fragments.length;i++){
            radioBtns[i]=(RadioButton)findViewById(tabIds[i]);
            if (i==0){
                ft.show(fragments[i]);
            }else {
                ft.hide(fragments[i]);
            }
        }
        ft.commitAllowingStateLoss();
        initdone = true;
    }
    public void fragmclick(View view) {
        if (!initdone || !ClickLimit.canClick(200)) {
            return;
        }
        int id = view.getId();
        framtran = fmanger.beginTransaction();
        for (int i = 0; i < tabIds.length; i++) {
            if (tabIds[i] == id) {
                if (!fragments[i].isAdded()) {
                    try {
                        framtran.add(R.id.framelayout, fragments[i], i + "");// 点击的时候才add，不需要一次性加载，让app启动更快一些
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                framtran = framtran.show(fragments[i]);
                radioBtns[i].setChecked(true);
            } else {
                framtran = framtran.hide(fragments[i]);
                radioBtns[i].setChecked(false);
            }
        }
        framtran.commitAllowingStateLoss();
    }
    private long exitTime = 0;
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            exitTime = System.currentTimeMillis();
            T.showMessage(MainActivity.this, "再按一次退出程序");
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
        if (arg1 == 22) {
            framtran = fmanger.beginTransaction();
            framtran = framtran.show(fragments[0]);
            radioBtns[0].setChecked(true);
            framtran = framtran.hide(fragments[3]);
            framtran.commitAllowingStateLoss();
        }
    }
}
