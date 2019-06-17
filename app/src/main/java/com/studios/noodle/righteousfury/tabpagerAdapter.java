package com.studios.noodle.righteousfury;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class tabpagerAdapter extends FragmentStatePagerAdapter {

    String[] tabarray = new String[]{"One", "Two", "Three"};


    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                tab1 Tab1 = new tab1();
                return Tab1;
            case 1:
                tab2 Tab2 = new tab2();
                return Tab2;
            case 2:
                tab3 Tab3 = new tab3();
                return Tab3;

        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
