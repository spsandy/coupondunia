package com.example.sandeep.couponduniatest.AsyncTasks;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sandeep.couponduniatest.callbacks.OnTaskCompleted;

import org.json.JSONObject;


/**
 * Created by sandeep on 23/11/15.
 */
public class RestReuests {
    OnTaskCompleted mTaskCompleted;
    Context mContext  = null;
    public  RestReuests( Context lContext){
        mContext = lContext;
    }
    public void RestRequestsObject(int method,String url,JSONObject jsonRequest,OnTaskCompleted lTaskCompleted) {
        mTaskCompleted = lTaskCompleted;
        RequestQueue queue = Volley.newRequestQueue(mContext);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(method, url, jsonRequest, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mTaskCompleted.onTaskCompleted(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("categories error",error.toString());
                mTaskCompleted.onTaskError(error);
            }
        });
        queue.add(jsObjRequest);
    }
}
