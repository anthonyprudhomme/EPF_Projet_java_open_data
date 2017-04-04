/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Model;

import java.util.ArrayList;
import java.util.Arrays;
import moviedatas.Log;

/**
 *
 * @author anthony
 */
public class Actor extends MovieMember implements Comparable{
    
    public static ArrayList<Actor> actors = new ArrayList<> ();
    private static int currentId = 0;
    
    public Actor(String name, int fbLikes, ArrayList<Movie> movies) {
        super(name, fbLikes, movies);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Actor)o).getName());
    }
    
    public static void updateActorList(String name, int fbLikes, Movie movie){
        if(actors.isEmpty()){
            actors.add(new Actor(name,fbLikes,new ArrayList<>(Arrays.asList(movie))));
        }else{
            boolean isAdded = false;
            for (int i = 0; i < actors.size(); i++) {
                if(actors.get(i).getName().equalsIgnoreCase(name)){
                    actors.get(i).addMovie(movie);
                    isAdded = true;
                }
            }
            if(!isAdded){
                actors.add(new Actor(name,fbLikes,new ArrayList<>(Arrays.asList(movie))));
            }
        }
    }
    
    public static int getId(String name){
        for (int i = 0; i < actors.size(); i++) {
            if(actors.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return currentId++;
    }
    
    private void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
