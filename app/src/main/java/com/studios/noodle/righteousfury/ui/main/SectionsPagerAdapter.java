package com.studios.noodle.righteousfury.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.studios.noodle.righteousfury.R;
import com.studios.noodle.righteousfury.Tab1_Character;
import com.studios.noodle.righteousfury.Tab2_Inventory;
import com.studios.noodle.righteousfury.Tab3_SkillsAndTraits;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3}; // add more arguments here, per tab required
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1_Character tab1_character = new Tab1_Character();
                return tab1_character;
            case 1:
                Tab2_Inventory tab2_inventory = new Tab2_Inventory();
                return tab2_inventory;
            case 2:
                Tab3_SkillsAndTraits tab3_skillsAndTraits = new Tab3_SkillsAndTraits();
                return tab3_skillsAndTraits;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show total pages. Increase Integer value to the amount of tabs you want
        return 3;
    }
}