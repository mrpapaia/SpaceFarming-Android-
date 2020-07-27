package com.example.spacefarming.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    private FragmentManager fm;

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.fm = fm;


    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment histNivel, Fragment histAbastecimento) {
        mFragmentList.add(histNivel);
        mFragmentList.add(histAbastecimento);
        mFragmentTitleList.add("Nível");
        mFragmentTitleList.add("Abastecimento");
    }

    public void replaceFragment(Fragment histNivel, Fragment histAbastecimento) {
        mFragmentList.remove(0);
        mFragmentList.remove(0);
        mFragmentList.add(histNivel);
        mFragmentList.add(histAbastecimento);


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
