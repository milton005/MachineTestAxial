package com.pado.machinetest.UI.Adapter;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pado.machinetest.UI.DynamicFragment;

import java.util.ArrayList;


public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    int numofTabs=0;
    ArrayList<String>list;
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm,int numofTabs,ArrayList<String>list) {
        super(fm);
        Context mContext = context;
        this.numofTabs=numofTabs;
        this.list=list;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
       return DynamicFragment.newInstance();
    }


    // This determines the number of tabs
    @Override
    public int getCount() {
        return numofTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
    // This determines the title for each tab


}