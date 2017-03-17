package com.myMovieDB.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Movies {
    private String title;

    private String year;

    private String poster;

    private String imdbID;

    private String type;

    private String Title;

    @JsonProperty("Title")
    public void setTitle(String Title) {
        this.title = Title;
    }


    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }



    public String getYear() {
        return year;
    }



    public String getPoster() {
        return poster;
    }


    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }
    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{ \"title\": \"" + this.title +"\"}";
    }

}

