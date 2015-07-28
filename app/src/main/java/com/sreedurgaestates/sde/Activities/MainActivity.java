package com.sreedurgaestates.sde.Activities;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sreedurgaestates.sde.Adapters.NavigationAdapter;
import com.sreedurgaestates.sde.Adapters.TabsAdapter;
import com.sreedurgaestates.sde.R;

import tabs.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {
    Toolbar toolbar;
    /**
     * data for navigation drawer
     */
    String TITLES[] = {"Home","About","Mail","Call","Address","Settings"};
    int ICONS[] = {R.drawable.home,R.drawable.direction,R.drawable.mail,R.drawable.call,R.drawable.address,R.drawable.settings};
    //header details
    String NAME = "Sree Durga Estates";
    String EMAIL = "sreedurgaestates.com";
    int PROFILE = R.drawable.home1;
    /**
     * recycler view and drawer layout
     */
    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter navigationAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout mDrawer;                                  // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle
    /**
     * tab layout and adapter
     */
    ViewPager pager;
    TabsAdapter tabsAdapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Present","Past","Future"};
    int Numboftabs =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *  set tool bar as action bar.
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         * setting recycler view in navigation drawer
         */
        //Assigning the RecyclerView Object to the xml View
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        //Letting the system know that the list objects are of fixed size
        mRecyclerView.setHasFixedSize(true);
        //Creating the Adapter object of NavigationAdapter class
        navigationAdapter = new NavigationAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);
        //set the adapter to the recycler view
        mRecyclerView.setAdapter(navigationAdapter);
        // Creating a layout Manager
        mLayoutManager = new LinearLayoutManager(this);
        // Setting the layout Manager
        mRecyclerView.setLayoutManager(mLayoutManager);
        /**
         * setting navigation drawer and syncing the state btw toolbar and navigation drawer
         */
        // Drawer object Assigned to the view
        mDrawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        // Drawer Toggle Object
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        };
        // Drawer Listener set to the Drawer toggle
        mDrawer.setDrawerListener(mDrawerToggle);
        // Finally we set the drawer toggle sync State
        mDrawerToggle.syncState();

    }
    @Override
    public  void onResume(){
        super.onResume();
        /**
         * setting tabs
         */
        // Creating The TabsAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        tabsAdapter =  new TabsAdapter(getSupportFragmentManager(),Titles,Numboftabs);
        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(tabsAdapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accentColor);
            }
        });
        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
