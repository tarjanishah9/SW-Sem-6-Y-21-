package com.tarjani.tabbardemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment f=null;
        switch (position){
            case 0:
                f=new ChatFragment();
                break;
            case 1:
                f=new StatusFragment();
                break;
            case 2:
                f=new CallFragment();
                break;

        }
        return f;

    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
