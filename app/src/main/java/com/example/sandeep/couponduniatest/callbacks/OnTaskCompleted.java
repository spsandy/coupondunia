package com.example.sandeep.couponduniatest.callbacks;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by lokesh on 23/11/15.
 */
public interface OnTaskCompleted {

    void onTaskCompleted(JSONObject response);
    void onTaskError(VolleyError response);


}


