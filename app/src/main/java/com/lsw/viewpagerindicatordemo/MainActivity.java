package com.lsw.viewpagerindicatordemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;
    private List<String> mDatas = Arrays.asList("精选1","书库2","我的3","精选4","书库5","我的6","精选7","书库8","我的9");
    private List<Fragment> mTabContents = new ArrayList<>();
    private FragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
        //设置Tab上的标题
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mPagerAdapter);
        //设置关联的ViewPager
        mIndicator.setViewPager(mViewPager,0);
    }

    private void initDatas() {
        for (String data : mDatas) {
            SimpleFragment simpleFragment = SimpleFragment.newInstance(data);
            mTabContents.add(simpleFragment);
        }

        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }

            @Override
            public int getCount() {
                return mTabContents.size();
            }
        };
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_page);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
    }
}
