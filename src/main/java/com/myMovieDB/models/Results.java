package com.myMovieDB.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Results {
    private Movies[] movies;

    private String totalResults;

    private String Response;

    public Movies[] getMovies() {
        return movies;
    }

    @JsonProperty("Search")
    public void setMovies(Movies[] Search) {
        this.movies = Search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    @JsonProperty("Response")
    public void setResponse(String Response) {
        this.Response = Response;
    }

    @Override
    public String toString() {
        return "ClassPojo [Movies = " + movies[0].toString() + ", totalResults = " + totalResults + ", Response = " + Response + "]";
    }
}