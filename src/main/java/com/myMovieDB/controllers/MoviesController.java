package com.myMovieDB.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myMovieDB.models.Movies;
import com.myMovieDB.models.Results;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("")
    public String getMovieQuery(@RequestParam String title) throws URISyntaxException, IOException {
        String url = "http://www.omdbapi.com/?s=" + title;
        URL urlObj = new URL(url);
        HttpURLConnection http = (HttpURLConnection) urlObj.openConnection();
        http.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(http.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        //print result
        TypeReference<Results> typeRef = new TypeReference<Results>() {};
        Results results = objectMapper.readValue(response.toString(),typeRef);

//        ArrayList<HashMap<String, String>> movie = (ArrayList<Map<String,String>>) movies.get("Search");
//        Map<String, Object> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//        map.putAll(movies);

//        String titles = movies.get("Title");
//        String imdbId = movies.get("imdbId");
//        String poster = movies.get("Poster");
//        String year = movies.get("Year");

//        System.out.println(results);
       // Movies movies1 = new Movies(titles, imdbId, poster, year);
//        ArrayList<HashMap<String, String>> moviesArray = (ArrayList<HashMap<String,String>>) map.get("Movies");
//
        System.out.println(results.getMovies());

        return results.toString();

    }

}
