package com.sreedurgaestates.sde.Adapters;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sreedurgaestates.sde.Fragments.Tab1;
import com.sreedurgaestates.sde.Fragments.Tab2;
import com.sreedurgaestates.sde.Fragments.Tab3;

/**
 * Created by hp1 on 21-01-2015.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when TabsAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the TabsAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class

    /**
     *
     * @param fm
     * @param mTitles
     * @param mNumbOfTabsumb
     */
    public TabsAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Tab1 tab1 = new Tab1();
            return tab1;
        }
        if(position == 1) // if the position is 1 we are returning the second tab
        {
            Tab2 tab2 = new Tab2();
            return tab2;
        }
        else
        {
            Tab3 tab3 = new Tab3();
            return tab3;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
