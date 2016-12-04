package com.example.chrispconnolly.popularmovies;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        try {
            Bitmap bitmap = this.getIntent().getParcelableExtra("movieBitmap");
            ImageView posterImageView = (ImageView) this.findViewById(R.id.poster_imageview);
            posterImageView.setImageBitmap(bitmap);

            TextView titleTextView = (TextView) this.findViewById(R.id.title_textview);
            TextView plotTextView = (TextView) this.findViewById(R.id.plot_textview);
            TextView ratingTextView = (TextView) this.findViewById(R.id.rating_textview);
            TextView releaseDateTextView = (TextView) this.findViewById(R.id.releasedate_textview);

            JSONObject movieJson = new JSONObject(this.getIntent().getExtras().getString("movieJson"));
            titleTextView.setText("Original Title: " + movieJson.getString("original_title"));
            plotTextView.setText("Plot: " + movieJson.getString("overview"));
            ratingTextView.setText("User Rating: " + movieJson.getString("vote_average"));
            releaseDateTextView.setText("Release Date: " + movieJson.getString("release_date"));
        }
        catch (JSONException e)
        {
            Log.e("JSON Exception: ", e.toString());
        }
    }
}
