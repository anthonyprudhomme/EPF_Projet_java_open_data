/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Model;

import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public abstract class MovieMember {
    
    String name;
    int fbLikes;
    ArrayList<Movie> movies;

    public MovieMember(String name, int fbLikes, ArrayList<Movie> movies) {
        this.name = name;
        this.fbLikes = fbLikes;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public int getFbLikes() {
        return fbLikes;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
    public void addMovieToList(Movie movieToAdd){
        this.movies.add(movieToAdd);
    }
}
