package com.example.sandeep.couponduniatest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sandeep.couponduniatest.R;
import com.example.sandeep.couponduniatest.models.RestaurantOutlets;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sandeep on 23/11/15.
 */
public class NearByAdapter extends BaseAdapter  {
    private Context mContext;
    private ArrayList<RestaurantOutlets> mRestaurantOutlets;
    public NearByAdapter(Context context,ArrayList<RestaurantOutlets>lRestaurantOutlets){
        mContext = context;
        mRestaurantOutlets = lRestaurantOutlets;
    }
    @Override
    public int getCount() {
        return mRestaurantOutlets.size();
    }
    @Override
    public Object getItem(int position) {
        return mRestaurantOutlets.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi = convertView;
        final ViewHolder holder;
        if (convertView == null) {
            vi  = inflater.inflate(R.layout.list_item_tab2, null);
            //Initialize ImageView
                holder = new ViewHolder();
            holder.scrollView = (HorizontalScrollView) vi.findViewById(R.id.horizontalScrollView);
            LinearLayout topLinearLayout = new LinearLayout(mContext);
            for (int i = 0; i < mRestaurantOutlets.get(position).getCategories().size(); i++){
                final ImageView imageView1= new ImageView (mContext);
                final TextView TextView1= new TextView (mContext);
                TextView1.setGravity(Gravity.CENTER);
                TextView1.setTag(i);
                imageView1.setTag(i);
                imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                TextView1.setText(mRestaurantOutlets.get(position).getCategories().get(i).getName());
                imageView1.setBackground(mContext.getResources().getDrawable(R.drawable.ic_checkbox_blank_circle_black_18dp));
                topLinearLayout.addView(imageView1);
                topLinearLayout.addView(TextView1);
                topLinearLayout.setPadding(0,30,0,0);
                Log.i("imageView1",i+"position"+position);
            }
            holder.scrollView.addView(topLinearLayout);
            holder.imageView = (ImageView) vi.findViewById(R.id.imageView);
            holder.outletName = (TextView) vi.findViewById(R.id.textView2);
            holder.Offers = (TextView) vi.findViewById(R.id.textView3);
            holder.Distance = (TextView) vi.findViewById(R.id.textView4);
            holder.Locality = (TextView) vi.findViewById(R.id.textView5);
            holder.Locality.setText(mRestaurantOutlets.get(position).getNeighbourhoodName());
            holder.Distance.setText(mRestaurantOutlets.get(position).getDistance()+"m");
            holder.outletName.setText(mRestaurantOutlets.get(position).getOutletName());
            holder.Offers.setText(mRestaurantOutlets.get(position).getNumCoupons() + " Offers");
            Picasso.with(mContext)
                    .load(mRestaurantOutlets.get(position).getLogoURL())
                    .into(holder.imageView);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
        return vi;
    }
    public static class ViewHolder {
        View grid;
        ImageView imageView;
        TextView outletName,Offers,Distance,Locality;
        HorizontalScrollView scrollView;
    }
}

