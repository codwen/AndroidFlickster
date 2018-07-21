package com.wendyjean.flickster.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wendyjean.flickster.R;
import com.wendyjean.flickster.models.Movie;

import java.util.List;

;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

     public MovieArrayAdapter(Context context, List<Movie> movies) {
           super(context, android.R.layout.simple_list_item_1, movies);
     }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        // get the data item for position
        Movie movie = getItem(position);

        //check the existing view beign used
        if (convertView == null ) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent , false);
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.MovieImage);
        // Clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvtitle = (TextView) convertView.findViewById(R.id.TvTitle);
        TextView tvoverview = (TextView) convertView.findViewById(R.id.textView);

        // populate the data
        tvtitle.setText(movie.getOriginalTitle());
        tvoverview.setText(movie.getOverview());

        // return the view
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        return convertView;

    }
}


