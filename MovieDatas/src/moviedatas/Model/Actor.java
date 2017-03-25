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
public class Actor extends MovieMember implements Comparable{
    
    public static ArrayList<Actor> actors;
    
    public Actor(String name, int fbLikes, ArrayList<Movie> movies) {
        super(name, fbLikes, movies);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Actor)o).getName());
    }
    
    //public static void updateActorList(String name, int fbLikes, Movie movie)
}
