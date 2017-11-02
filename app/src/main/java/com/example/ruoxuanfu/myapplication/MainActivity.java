package com.example.ruoxuanfu.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ruoxuanfu.myapplication.adapter.ChooseListAdapter;
import com.example.ruoxuanfu.myapplication.fragments.FragmentAdvance;
import com.example.ruoxuanfu.myapplication.fragments.FragmentLink;
import com.example.ruoxuanfu.myapplication.fragments.FragmentPhoto;
import com.example.ruoxuanfu.myapplication.fragments.FragmentSetting;
import com.example.ruoxuanfu.myapplication.fragments.FragmentTheme;
import com.example.ruoxuanfu.myapplication.listener.setOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends SupportActivity {

    private RecyclerView mChooseList;
    private FrameLayout mFrameLayout;

    private FragmentLink mFragmentLink;
    private FragmentAdvance mFragmentAdvance;
    private FragmentSetting mFragmentSetting;
    private FragmentTheme mFragmentTheme;
    private FragmentPhoto mFragmentPhoto;

    private List<String> mOptionData;

    private SupportFragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mChooseList = (RecyclerView) findViewById(R.id.chooseList);
        mFrameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        // 加载Fragment
        if (findFragment(FragmentLink.class) == null) {
            mFragmentLink = FragmentLink.newInstance();
            mFragmentSetting = FragmentSetting.newInstance();
            mFragmentAdvance = FragmentAdvance.newInstance();
            mFragmentPhoto = FragmentPhoto.newInstance();
            mFragmentTheme = FragmentTheme.newInstance();

            //添加同级的fragment
            //loadMultipleRootFragment(R.id.frameLayout, 0, mFragmentLink, mFragmentSetting, mFragmentAdvance, mFragmentPhoto, mFragmentTheme);
            loadRootFragment(R.id.frameLayout, mFragmentLink);
        } else {
            mFragmentLink = findFragment(FragmentLink.class);
            mFragmentSetting = findFragment(FragmentSetting.class);
            mFragmentAdvance = findFragment(FragmentAdvance.class);
            mFragmentPhoto = findFragment(FragmentPhoto.class);
            mFragmentTheme = findFragment(FragmentTheme.class);
        }
        mFragments = new SupportFragment[]{mFragmentLink, mFragmentSetting, mFragmentAdvance, mFragmentPhoto, mFragmentTheme};
    }

    private void initData() {
        loadOptionData();
        ChooseListAdapter adapter = new ChooseListAdapter(mOptionData);
        mChooseList.setAdapter(adapter);
        mChooseList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter.setHasSelect(0);
        adapter.setSetOnItemClickListener(new setOnItemClickListener() {
            @Override
            public void setOnClickListener(final int position) {
                Toast.makeText(MainActivity.this, "点击： " + mOptionData.get(position), Toast.LENGTH_SHORT).show();
/*                switch (position) {
                    case 0:
                        showHideFragment(mFragmentLink);
                        break;
                    case 1:
                        showHideFragment(mFragmentSetting);
                        break;
                    case 2:
                        showHideFragment(mFragmentAdvance);
                        break;
                    case 3:
                        showHideFragment(mFragmentPhoto);
                        break;
                    case 4:
                        showHideFragment(mFragmentTheme);
                        break;
                }*/
                if (mFragments[position] == null) {
                    popTo(mFragments[position].getClass(), false, new Runnable() {
                        @Override
                        public void run() {
                            try {
                                start(mFragments[position].getClass().newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    // 如果已经在栈内,则以SingleTask模式start
                    start(mFragments[position], SupportFragment.SINGLETASK);
                }
            }
        });
    }

    private void loadOptionData() {
        mOptionData = new ArrayList<>();
        mOptionData.add(0, "连接");
        mOptionData.add(1, "设置");
        mOptionData.add(2, "高级选项");
        mOptionData.add(3, "图片");
        mOptionData.add(4, "换肤");
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultVerticalAnimator();
    }
}
