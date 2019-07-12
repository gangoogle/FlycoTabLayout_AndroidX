package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.flyco.tablayout.ScrollTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.utils.FragmentUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ScrollTabActivity extends AppCompatActivity implements OnTabSelectListener {
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int mCurrentIndex;
    private ArrayList<String> mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        ScrollTabLayout tabLayout_1 = findViewById(R.id.tablayout);

        mTabs= new ArrayList<>();
        Collections.addAll(mTabs, mTitles);
        tabLayout_1.setTabs(mTabs);
        tabLayout_1.setOnTabSelectListener(this);
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.fl_content, mCurrentIndex);
    }

    @Override
    public void onTabSelect(int position) {
        FragmentUtils.showHide(mCurrentIndex = position, mFragments);
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

}
