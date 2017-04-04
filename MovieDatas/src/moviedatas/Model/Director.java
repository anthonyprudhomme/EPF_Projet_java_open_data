/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Model;

import java.util.ArrayList;
import java.util.Arrays;
import static moviedatas.Model.Actor.actors;

/**
 *
 * @author anthony
 */
public class Director extends MovieMember{
    
    public static ArrayList<Director> directors = new ArrayList<>();

   public static int getId(String name){
        for (int i = 0; i < directors.size(); i++) {
            if(directors.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return directors.size();
    }
    
    public Director(String name, int fbLikes, ArrayList<Movie> movies) {
        super(name, fbLikes, movies);
    }
    
    public static void updateDirectorList(String name, int fbLikes, Movie movie){
        if(directors.isEmpty()){
            directors.add(new Director(name,fbLikes,new ArrayList<>(Arrays.asList(movie))));
        }else{
            boolean isAdded = false;
            for (int i = 0; i < directors.size(); i++) {
                if(directors.get(i).getName().equalsIgnoreCase(name)){
                    directors.get(i).addMovie(movie);
                    isAdded = true;
                }
            }
            if(!isAdded){
                directors.add(new Director(name,fbLikes,new ArrayList<>(Arrays.asList(movie))));
            }
        }
    }
    
    private void addMovie(Movie movie){
        this.movies.add(movie);
    }
    
}
