package com.example.ruoxuanfu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruoxuanfu.myapplication.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by ruoxuan.fu on 2017/11/1.
 * <p>
 * Code is far away from bug with WOW protecting.
 */

public class FragmentAdvance extends SupportFragment {

    public static FragmentAdvance newInstance() {
        FragmentAdvance fragmentAdvance = new FragmentAdvance();
        Bundle bundle = new Bundle();
        fragmentAdvance.setArguments(bundle);
        return fragmentAdvance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advance, container, false);
        return view;
    }
}
