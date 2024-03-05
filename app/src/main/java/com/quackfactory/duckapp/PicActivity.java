package com.quackfactory.duckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;


public class PicActivity extends AppCompatActivity {
    private static final String TAG = "PicActivity";
    Button picGoHomeButton;
    Button picRefresh;
    ImageView duckImageView;

    String stringReturned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);

        duckImageView = findViewById(R.id.duck_pic_imageView);
        getDuckPic(getResources().getString(R.string.duck_api_url));

        picGoHomeButton = findViewById(R.id.pic_return_home_button);
        picGoHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        picRefresh = findViewById(R.id.refresh_duck_button);

        picRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDuckPic(getResources().getString(R.string.duck_api_url));
            }
        });

    }

    public void getDuckPic(String url){     // try making this return nothing: void
        // extract the json data
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject duckData = response;
                try {
                    stringReturned = response.getString("url");
                } catch (Exception e){
                    Log.d(TAG, "Failed because : " + e.getMessage());
                    stringReturned = "https://random-d.uk/api/220.jpg";  // hard coding cute running duck for now on failure
                }
                Picasso.get().load(stringReturned).into(duckImageView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PicActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(objectRequest);
        // return stringReturned;
    }
}