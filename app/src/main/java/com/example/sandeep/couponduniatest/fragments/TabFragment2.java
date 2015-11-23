package com.example.sandeep.couponduniatest.fragments;

/**
 * Created by sandeep on 23/11/15.
 */

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sandeep.couponduniatest.MainActivity;
import com.example.sandeep.couponduniatest.R;
import com.example.sandeep.couponduniatest.adapter.NearByAdapter;
import com.example.sandeep.couponduniatest.models.RestaurantOutlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class TabFragment2 extends Fragment {
    private ListView mNearByListView;
    private TextView mMyLocation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        mNearByListView = (ListView) view.findViewById(R.id.listView);
        mMyLocation     = (TextView) view.findViewById(R.id.loction);
        mMyLocation.setText(GetLocality());
        NearByAdapter lNearByAdapter = new NearByAdapter(getActivity(),getNearByItems());
        mNearByListView.setAdapter(lNearByAdapter);
        return view;
    }
    class SortBasedOnDistamnce implements Comparator<RestaurantOutlets> {
        @Override
        public int compare(RestaurantOutlets lhs, RestaurantOutlets rhs) {
            return Float.compare(Float.parseFloat(lhs.getDistance()),Float.parseFloat(rhs.getDistance()));
        }
    }
    public ArrayList<RestaurantOutlets> getNearByItems() {
        ArrayList<RestaurantOutlets> lList = new ArrayList<>();
        for(RestaurantOutlets lRestaurantOutlets : MainActivity.mRestaurantOutlets){
            RestaurantOutlets l = new RestaurantOutlets();
            l.setOutletName(lRestaurantOutlets.getOutletName());
            l.setCategories(lRestaurantOutlets.getCategories());
            l.setNumCoupons(lRestaurantOutlets.getNumCoupons());
            float[]results= new float[1];
            Location.distanceBetween((double) MainActivity.mLatitude,
                    (double) MainActivity.mLongitude,
                    (double) Double.parseDouble(lRestaurantOutlets.getLatitude()),
                    (double) Double.parseDouble(lRestaurantOutlets.getLongitude()), results);

            Log.i("distance",results[0]+"m"+"getOutletName"+l.getOutletName());
            l.setDistance(results[0]+"");
            l.setNeighbourhoodName(lRestaurantOutlets.getNeighbourhoodName());
            l.setLogoURL(lRestaurantOutlets.getLogoURL());
            lList.add(l);
        }
        Collections.sort(lList, new SortBasedOnDistamnce());

        for (RestaurantOutlets ll:lList){
            Log.i("getOutletName",ll.getOutletName());
        }
        return lList;
    }
    private String GetLocality() {
        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(getActivity(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(MainActivity.mLatitude,MainActivity.mLongitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(addresses!=null)
            return addresses.get(0).getSubLocality();
        else
            return "Bangalore";
    }
}