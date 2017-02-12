package com.www.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.www.app.R;
import com.www.app.dao.BaseFragment;
import com.www.app.network.MQuery;

/**
 * Created by Bin on 2016/10/22.
 */

public class WanFragment extends BaseFragment {
    View view;
    private MQuery mq;
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wan,container,false);
        return view;
    }

    @Override
    public void initData() {
        mq = new MQuery(view);
        mq.id(R.id.my_title).text("玩购");

    }

    @Override
    public void initView() {

    }
}
