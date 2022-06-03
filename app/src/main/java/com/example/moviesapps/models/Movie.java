package com.example.moviesapps.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel

public class Movie {


    String title;
    String overview;
    String posterPath;
    String backdropPath;
    Double voteAverage;



    public Double getVoteAverage() {
        return voteAverage;
    }




    // no-arg, empty constructor required for Parceler
    public Movie() {}

    public Movie(JSONObject movie) throws JSONException {
        title = movie.getString("title");
        overview = movie.getString("overview");
        posterPath = movie.getString("poster_path");
        backdropPath = movie.getString("backdrop_path");
        voteAverage = movie.getDouble("vote_average");
    }

//    public Movie(JSONObject jsonObject){
//        try {
//            backdropPath = jsonObject.getString("backdrop_path");
//            posterPath = jsonObject.getString("poster_path");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            title = jsonObject.getString("title");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            overview = jsonObject.getString("overview");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for(int i =0; i < movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w342" + posterPath;
    }

    public String getBackdropPath(){
    return "https://image.tmdb.org/t/p/w342" + backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

}
