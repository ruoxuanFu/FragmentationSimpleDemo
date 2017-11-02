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

public class FragmentPhoto extends SupportFragment {

    public static FragmentPhoto newInstance() {
        FragmentPhoto fragmentPhoto = new FragmentPhoto();
        Bundle bundle = new Bundle();
        fragmentPhoto.setArguments(bundle);
        return fragmentPhoto;
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        return view;
    }
}
