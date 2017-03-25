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
public class Director extends MovieMember{
    
    public Director(String name, int fbLikes, ArrayList<Movie> movies) {
        super(name, fbLikes, movies);
    }
    
}
