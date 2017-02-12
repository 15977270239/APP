package com.www.app.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;
import com.www.app.R;
import com.www.app.adapter.MyRecyclerAdapter;
import com.www.app.dao.BaseActivity;
import com.www.app.enty.Price;
import com.www.app.network.MQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bin on 2016/10/22.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    MQuery mq;
    private MyRecyclerAdapter adapter;
    private List<Price> list;
    private Price price;
    private RecyclerView rv;
    private LinearLayoutManager linearLayoutManager;
    /* CALL_PHONE Constant Permission */
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    /* GPS Constant Permission */
    private static final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;
    private static final int MY_PERMISSION_ACCESS_FINE_LOCATION = 12;

    /* Position */
    private static final int MINIMUM_TIME = 10000;  // 10s
    private static final int MINIMUM_DISTANCE = 50; // 50m

    /* GPS */
    private String mProviderName;
    private LocationManager mLocationManager;
    private LocationListener mLocationListener;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    public void createActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initData() {
        mq = new MQuery(this);
        mq.id(R.id.my_title).text("登陆");
        mq.id(R.id.back).clicked(this);
        mq.id(R.id.phone).clicked(this);
        rv = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void initView() {
        getData();

    }

    private void getData() {
        list = new ArrayList<>();
        price = new Price("89.52");
        list.add(price);
        price = new Price("219.42");
        list.add(price);
        price = new Price("3389.52");
        list.add(price);
        adapter = new MyRecyclerAdapter(this, list);
        rv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.phone:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    String[] mPermissionList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS};
//                    ActivityCompat.requestPermissions(LoginActivity.this, mPermissionList, 100);
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);
                } else {
                    startActivity(intent);
                }

                break;
        }
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
//    {
//
//        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE)
//        {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//
//            } else
//            {
//                // Permission Denied
//                Toast.makeText(LoginActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//            return;
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
}
