/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import moviedatas.Log;
import moviedatas.Model.Actor;
import moviedatas.Model.Director;
import moviedatas.Model.Movie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author anthony
 */
public class MovieListController {
    
    private ArrayList<Movie> movies = new ArrayList<>();
    
    public void initMovies(){
        String moviesString = loadMoviesFromFile();
        JSONArray movieDatas = (JSONArray) JSONValue.parse(moviesString);
        Log.e(movieDatas.size());
        Log.e(movieDatas.get(0));
        /*ArrayList<Movie> actorMovies = null;
        Actor actor = new Actor("John Doe", 5000,actorMovies);
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(actor);
        Movie movie = new Movie("Avatar",2000,"Action",150, new Director(null,0,null),actors,1.3,100,100,"France","French",true,"link",new ArrayList<String>() );
        Log.e(movie.getActors().get(0).getMovies());
        actorMovies.add(movie);
        Log.e(movie.getActors().get(0).getMovies().size());*/
        for (int i =0; i < movieDatas.size(); i++){
        //for (int i =0; i < 10; i++){
            //Log.e(movieDatas.get(i));
            String title = ((JSONObject)movieDatas.get(i)).get("movie_title").toString();
            int releaseYear = 0;
            if(((JSONObject)movieDatas.get(i)).get("title_year") != null){
                releaseYear = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("title_year").toString());
            }
            String genresNotSplitted = ((JSONObject)movieDatas.get(i)).get("genres").toString();
            String[] genresSplitted = genresNotSplitted.split("\\|");
            ArrayList<String> genres = new ArrayList<>();
            genres.addAll(Arrays.asList(genresSplitted));
            int duration = 0;
            if(((JSONObject)movieDatas.get(i)).get("duration") != null){
                duration = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("duration").toString());
            }
            double score = 0;
            if(((JSONObject)movieDatas.get(i)).get("duration") != null){
                score = Double.parseDouble(((JSONObject)movieDatas.get(i)).get("duration").toString());
            }
            long gross = 0;
            if(((JSONObject)movieDatas.get(i)).get("gross") != null){
                gross = Long.parseLong(((JSONObject)movieDatas.get(i)).get("gross").toString());
            }
            long budget = 0;
            if(((JSONObject)movieDatas.get(i)).get("budget") != null){
                budget = Long.parseLong(((JSONObject)movieDatas.get(i)).get("budget").toString());
            }
            String country = ((JSONObject)movieDatas.get(i)).get("country").toString();
            String language = ((JSONObject)movieDatas.get(i)).get("language").toString();
            String coloredStr = ((JSONObject)movieDatas.get(i)).get("color").toString();
            boolean colored = false;
            if(coloredStr.equalsIgnoreCase("color")){
                colored = true;
            }
            String linkToInformation = ((JSONObject)movieDatas.get(i)).get("movie_imdb_link").toString();
            String keywords = ((JSONObject)movieDatas.get(i)).get("plot_keywords").toString();
            String[] kewordsSplitted = keywords.split("\\|");
            ArrayList<String> plotKeywords = new ArrayList<>();
            for (int j = 0; j < kewordsSplitted.length; j++) {
                plotKeywords.add(kewordsSplitted[j]);
            }
            
            String actor1Name = ((JSONObject)movieDatas.get(i)).get("actor_1_name").toString();
            int actor1FbLikes = 0;
            if(((JSONObject)movieDatas.get(i)).get("actor_1_facebook_likes") != null){
                actor1FbLikes = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("actor_1_facebook_likes").toString());
            }
            int actor1Id = Actor.getId(actor1Name);
            
            String actor2Name = ((JSONObject)movieDatas.get(i)).get("actor_2_name").toString();
            int actor2FbLikes = 0;
            if(((JSONObject)movieDatas.get(i)).get("actor_2_facebook_likes") != null){
                actor2FbLikes = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("actor_2_facebook_likes").toString());
            }
            int actor2Id = Actor.getId(actor2Name);
            
            String actor3Name = ((JSONObject)movieDatas.get(i)).get("actor_3_name").toString();
            int actor3FbLikes = 0;
            if(((JSONObject)movieDatas.get(i)).get("actor_3_facebook_likes") != null){
                actor3FbLikes = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("actor_3_facebook_likes").toString());
            }
            int actor3Id = Actor.getId(actor3Name);
            
            ArrayList<Integer> actorsId = new ArrayList<>();
            if(actor1Id != -1){
                actorsId.add(actor1Id);
            }
            if(actor2Id != -1){
                actorsId.add(actor2Id);
            }
            if(actor3Id != -1){
                actorsId.add(actor3Id);
            }
            
            String directorName = ((JSONObject)movieDatas.get(i)).get("director_name").toString();
            int directorFbLikes = 0;
            if(((JSONObject)movieDatas.get(i)).get("director_facebook_likes") != null){
                directorFbLikes = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("director_facebook_likes").toString());
            }
            int directorId = Director.getId(directorName);
            
            int fbLikes = 0;
            if(((JSONObject)movieDatas.get(i)).get("movie_facebook_likes") != null){
                fbLikes = Integer.parseInt(((JSONObject)movieDatas.get(i)).get("movie_facebook_likes").toString());
            }
            Movie currentMovie = new Movie(title,releaseYear,genres,duration,directorId,actorsId,score,gross,budget,
                    country,language,colored,linkToInformation,plotKeywords,fbLikes);
            movies.add(currentMovie);
            
            Actor.updateActorList(actor1Name, actor1FbLikes, currentMovie);
            Actor.updateActorList(actor2Name, actor2FbLikes, currentMovie);
            Actor.updateActorList(actor3Name, actor3FbLikes, currentMovie);
            Director.updateDirectorList(directorName, directorFbLikes, currentMovie);
            
        }
    }
    
    // Method that load movies from the json file
    private String loadMoviesFromFile(){
        // String that will contain the whole json file
        String moviesString = "";
        // Object used to read the file
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./src/moviedatas/MovieDatas.json"));
        
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                moviesString = sb.toString();
            } catch (IOException ex) {
                Logger.getLogger(MovieListController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(MovieListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovieListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return moviesString;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
}
