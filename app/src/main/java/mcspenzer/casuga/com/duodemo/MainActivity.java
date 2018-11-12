package mcspenzer.casuga.com.duodemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;


import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity {

    // For DuoDrawer Menu
    DuoMenuView mDuoMenuView;

    // For DuoDrawer Layout
    DuoDrawerLayout mDuoDrawerLayout;
    DuoDrawerToggle mDuoDrawerToggle;

    // For Toolbar (dependency of DuoDrawerToggle)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar initialization
        mToolbar = findViewById(R.id.main_toolbar);

        // DuoDrawer Menu View initialization
        mDuoMenuView = findViewById(R.id.main_duoDrawerMenuView);

        MenuAdapter menuAdapter = new MenuAdapter(getMenuItems());
        mDuoMenuView.setAdapter(menuAdapter);

        mDuoMenuView.setOnMenuClickListener(new DuoMenuView.OnMenuClickListener() {
            @Override
            public void onFooterClicked() {
                makeToastText(MainActivity.this, "Footer Clicked");
            }

            @Override
            public void onHeaderClicked() {
                makeToastText(MainActivity.this, "Header Clicked");
            }

            @Override
            public void onOptionClicked(int position, Object objectClicked) {
                makeToastText(MainActivity.this, objectClicked.toString());
            }
        });

        // DuoDrawer Layout initialization
        mDuoDrawerLayout = findViewById(R.id.main_duoDrawerLayout);
        mDuoDrawerToggle = new DuoDrawerToggle(MainActivity.this, mDuoDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDuoDrawerLayout.setDrawerListener(mDuoDrawerToggle);
        mDuoDrawerToggle.syncState();
    }

    private ArrayList<String> getMenuItems() {
        ArrayList<String> theArrayList = new ArrayList<>();

        theArrayList.add("Home");
        theArrayList.add("Talk with SAI");
        theArrayList.add("Track my Mood");
        theArrayList.add("My Thoughts");
        theArrayList.add("My Progress");

        return theArrayList;
    }

    private void makeToastText(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
