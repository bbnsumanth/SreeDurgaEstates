package com.sreedurgaestates.sde;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


public class AboutActivity extends ActionBarActivity {
    String about = "\n" +
            "About Us\n" +
            "\n" +
            "Sree Durga is one of the leading groups of companies based in Hyderabad, engaged in various segments of construction with a primal focus on residential, commercial, retail and infrastructure projects.\n" +
            "\n" +
            "The prime driving force behind the group being customer oriented approach with timely delivery adhering to stringent quality benchmarks. In the last 13 years of its existence has constructed more than one million Sq.ft of commercial and residential space in Hyderabad with another five million Sq.ft of space in the running projects.\n" +
            "\n" +
            "As cart of the construction fraternity, the Sree Durga is aware of its social commitments and responsibilities. At Sree Durga, we view ourselves as stakeholders in building the future-of our Hyderabad city, plush, Green and in sync with the changing times, it has always been our endeavour to blend harmoniously into the progress of the city, its ambience, its culture and more importantly its infrastructure.\n" +
            "\n" +
            "We have Constructed Duplex Houses, Apartments and infra projects.\n" +
            "\n" +
            "100 acres venture near Shamshabad\n" +
            "28 acres Mallampet\n" +
            "28 acres Dindigal\n" +
            "24 acres Bachupally, Miyapur\n" +
            "Heritage Foods\n" +
            "Navabharath\n" +
            "Tirumala Dairy\n" +
            "Vibha Seeds\n" +
            "Mission\n" +
            "\n" +
            "Provide high quality products and services in the housing and construction sector with a promise delivering trio goods as promised adhering to the timelines with a strong emphasis on maintaining quality at all levels.\n" +
            "\n" +
            "Vision\n" +
            "\n" +
            "To become one of the leading players in changing the landscape of the country's infrastructure by introducing innovative practices with the commitment and social responsibility required to keep the overall growth in the sector in harmony.\n" +
            "\n" +
            "Mr. Boppana Ramesh B. E. Mech.\n" +
            "\n" +
            "Aged about 39 years, Boppana Ramesh hails from a business family engaged in running Para-Boiled rice mills. A mechanical engineer with over 13 years of experience in various domains including software consultancy in IBM mainframes and process industries like high capacity parboiled rice mills. After working as a consultant in various software projects, he joined \"Hi-Rise Projects\" as a partner in the year 2000. Construction activity and \"Hi-Rise Infrastructures\" in 2000 to do Infrastructure activities. The Hi-Rise is now we started as Sree Vijay Durga estates in which currently he is at the helm of affairs in Business Development/ Marketing.";

    String TITLES[] = {"Home","About","Mail","Call","Address","Settings"};
    int ICONS[] = {R.drawable.home,R.drawable.direction,R.drawable.mail,R.drawable.call,R.drawable.address,R.drawable.settings};
    String NAME = "Sree Durga Estates";
    String EMAIL = "sreedurgaestates.com";
    int PROFILE = R.drawable.home1;


    Toolbar toolbar;
    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout mDrawer;                                  // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle


    TextView textView;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        textView = (TextView) findViewById(R.id.description);
        textView.setText(about);



        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        mDrawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.openDrawer,R.string.closeDrawer);
    }


        public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

            private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
            // IF the view under inflation and population is header or Item
            private static final int TYPE_ITEM = 1;

            private String mNavTitles[]; // String Array to store the passed titles Value from MainActivity.java
            private int mIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

            private String name;        //String Resource for header View Name
            private int profile;        //int Resource for header view profile picture
            private String email;       //String Resource for header view email


            // Creating a ViewHolder which extends the RecyclerView View Holder
            // ViewHolder are used to to store the inflated views in order to recycle them

            public class ViewHolder extends RecyclerView.ViewHolder {
                int Holderid;

                TextView textView;
                ImageView imageView;
                ImageView profile;
                TextView Name;
                TextView email;


                public ViewHolder(View itemView, int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
                    super(itemView);


                    // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

                    if (ViewType == TYPE_ITEM) {
                        textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
                        imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
                        Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
                    } else {


                        Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
                        email = (TextView) itemView.findViewById(R.id.email);       // Creating Text View object from header.xml for email
                        profile = (ImageView) itemView.findViewById(R.id.circleView);// Creating Image view object from header.xml for profile pic
                        Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
                    }
                }


            }


            MyAdapter(String Titles[], int Icons[], String Name, String Email, int Profile) { // MyAdapter Constructor with titles and icons parameter
                // titles, icons, name, email, profile pic are passed from the main activity as we
                mNavTitles = Titles;                //have seen earlier
                mIcons = Icons;
                name = Name;
                email = Email;
                profile = Profile;                     //here we assign those passed values to the values we declared here
                //in adapter
            }


            //Below first we ovverride the method onCreateViewHolder which is called when the ViewHolder is
            //Created, In this method we inflate the item_row.xml layout if the viewType is Type_ITEM or else we inflate header.xml
            // if the viewType is TYPE_HEADER
            // and pass it to the view holder

            @Override
            public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                if (viewType == TYPE_ITEM) {
                    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
                    //Inflating the layout

                    ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view

                    return vhItem; // Returning the created object

                    //inflate your layout and pass it to view holder

                } else if (viewType == TYPE_HEADER) {

                    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false); //Inflating the layout

                    ViewHolder vhHeader = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view

                    return vhHeader; //returning the object created


                }
                return null;

            }

            //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
            // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
            // which view type is being created 1 for item row
            @Override
            public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
                if (holder.Holderid == 1) {                              // as the list view is going to be called after the header view so we decrement the
                    // position by 1 and pass it to the holder while setting the text and image
                    holder.textView.setText(mNavTitles[position - 1]); // Setting the Text with the array of our Titles
                    holder.imageView.setImageResource(mIcons[position - 1]);// Settimg the image with array of our icons
                } else {

                    holder.profile.setImageResource(profile);           // Similarly we set the resources for header view
                    holder.Name.setText(name);
                    holder.email.setText(email);
                }
            }

            // This method returns the number of items present in the list
            @Override
            public int getItemCount() {
                return mNavTitles.length + 1; // the number of items in the list will be +1 the titles including the header view.
            }


            // Witht the following method we check what type of view is being passed
            @Override
            public int getItemViewType(int position) {
                if (isPositionHeader(position))
                    return TYPE_HEADER;

                return TYPE_ITEM;
            }

            private boolean isPositionHeader(int position) {
                return position == 0;
            }
        }


            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
