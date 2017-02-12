package com.www.app.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.www.app.R;
import com.www.app.dao.BaseFragment;
import com.www.app.network.MQuery;
import com.www.app.ui.LoginActivity;
import com.www.app.utils.ScreenUtil;

/**
 * Created by Bin on 2016/10/22.
 */

public class QiangFragment extends BaseFragment implements View.OnClickListener{
    View view;
    private  MQuery mq;
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_qiang,container,false);
        return view;
    }

    @Override
    public void initData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LinearLayout ly = (LinearLayout) view.findViewById(R.id.title_ly);
            ly.setPadding(0, ScreenUtil.getStatusHeight(getActivity()), 0, 0);
        }
        mq = new MQuery(view);
        mq.id(R.id.my_title).text("抢购");
        mq.id(R.id.my_title).clicked(this);
        mq.id(R.id.phone).clicked(this);

    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_title:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.phone:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
                startActivity(intent);
                break;
        }
    }
}
