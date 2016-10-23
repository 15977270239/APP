package com.www.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.www.app.R;
import com.www.app.dao.BaseFragment;

/**
 * Created by Bin on 2016/10/22.
 */

public class MeFragment extends BaseFragment {
    View view;
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_me,container,false);
        return view;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }
}
