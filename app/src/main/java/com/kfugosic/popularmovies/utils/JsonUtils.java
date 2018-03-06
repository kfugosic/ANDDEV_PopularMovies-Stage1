package com.kfugosic.popularmovies.utils;

import com.kfugosic.popularmovies.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristijan on 06-Mar-18.
 */

public class JsonUtils {

    private static final String JSON_ALL_RESULTS = "results";
    private static final String JSON_MOVIE_ID = "id";
    private static final String JSON_MOVIE_TITLE = "original_title";
    private static final String JSON_MOVIE_OVERVIEW = "overview";
    private static final String JSON_POSTER_PATH = "poster_path";
    private static final String JSON_USER_RATING = "vote_average";
    private static final String JSON_RELEASE_DATE = "release_date";

    public static List<Movie> parseMovieJson(String json) {
        List<Movie> movies = new ArrayList<>();
        try {
            JSONObject moviesJson = new JSONObject(json);
            JSONArray allMovies = moviesJson.getJSONArray(JSON_ALL_RESULTS);
            for (int i = 0; i < allMovies.length(); i++) {
                JSONObject currentMovie = allMovies.getJSONObject(i);
                Movie newMovie = new Movie(
                        currentMovie.optString(JSON_MOVIE_ID),
                        currentMovie.optString(JSON_MOVIE_TITLE),
                        currentMovie.optString(JSON_MOVIE_OVERVIEW),
                        currentMovie.optString(JSON_POSTER_PATH),
                        currentMovie.optString(JSON_USER_RATING),
                        currentMovie.optString(JSON_RELEASE_DATE)
                );
                movies.add(newMovie);
            }
        } catch (JSONException e) {
            movies = null;
            e.printStackTrace();
        }
        return movies;
    }
}
