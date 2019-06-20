package com.studios.noodle.righteousfury;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class tabPagerAdapter extends FragmentStatePagerAdapter {

    String[] tabArray = new String[]{"Character", "Inventory", "Skills & Traits"};


    // tabPagerAdapter constructor method
    public tabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabArray[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                tab1Character tab1 = new tab1Character();
                return tab1;
            case 1:
                tab2Inventory tab2 = new tab2Inventory();
                return tab2;
            case 2:
                tab3SkillsandTraits tab3 = new tab3SkillsandTraits();
                return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
