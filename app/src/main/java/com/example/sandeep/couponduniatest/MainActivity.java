package com.example.sandeep.couponduniatest;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.sandeep.couponduniatest.AsyncTasks.RestReuests;
import com.example.sandeep.couponduniatest.adapter.PagerAdapter;
import com.example.sandeep.couponduniatest.callbacks.OnTaskCompleted;
import com.example.sandeep.couponduniatest.models.Categories;
import com.example.sandeep.couponduniatest.models.RestaurantOutlets;
import com.example.sandeep.couponduniatest.utility.RestConstatnts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted{
    public static List<RestaurantOutlets> mRestaurantOutlets;
    public static   Double mLatitude=null;
    public static   Double mLongitude=null;
    protected LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MaKeRequest();

        if(isLocationEnabled(MainActivity.this)) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc != null) {
                mLongitude = loc.getLongitude();
                mLatitude = loc.getLatitude();
            }
        }else {
            Toast.makeText(MainActivity.this,"Please Enable Location And Try Again!!",Toast.LENGTH_LONG).show();
            mLatitude = 12.9351660;
            mLongitude = 77.6093860;
        }
    }
    public  boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }
    private void SetTabLayout(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("IN YOUR CITY"));
        tabLayout.addTab(tabLayout.newTab().setText("NEARBY"));
        tabLayout.addTab(tabLayout.newTab().setText("BEST OFFERS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void MaKeRequest() {
        RestReuests restReuests =new RestReuests(MainActivity.this);
        restReuests.RestRequestsObject(Request.Method.GET, RestConstatnts.URL, null, MainActivity.this);
    }
    @Override
    public void onTaskCompleted(JSONObject response) {
        Log.i("response", response.toString());
        ParseJson(response);
        SetTabLayout();

    }
    private void ParseJson(JSONObject response) {
        Gson gson = new GsonBuilder().create();
        JSONObject myJson=null;
        JSONArray jsonArraydata=null;
        try {
            myJson          = new JSONObject(response.toString());
            jsonArraydata = myJson.getJSONArray("data");
        } catch (JSONException e) {
        }
        mRestaurantOutlets = Arrays.asList((gson.fromJson(jsonArraydata.toString(), RestaurantOutlets[].class)));
        Log.i("response", ((Categories) ((RestaurantOutlets) mRestaurantOutlets.get(0)).getCategories().get(0)).getName());
    }
    @Override
    public void onTaskError(VolleyError response) {
        Log.i("VolleyError",response.toString());
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

}
