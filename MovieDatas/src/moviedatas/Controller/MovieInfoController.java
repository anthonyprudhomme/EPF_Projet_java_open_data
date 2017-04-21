/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Controller;

import javax.swing.JPanel;
import moviedatas.Model.Movie;
import moviedatas.View.MovieInfoView;

/**
 *
 * @author anthony
 */
public class MovieInfoController implements MovieInfoControllerInterface{
    private MovieInfoView movieInfoView = new MovieInfoView();
    public static MovieInfoControllerInterface observer;
    
    public JPanel initView(){
        observer = this;
        return movieInfoView.createViewPanel();
    }
    
    public void updateViewWithMovie(Movie movie){
        movieInfoView.updateInformations(movieInfoView.getInfoPanel(), movie);
    }

    @Override
    public void newMovieSelected(Movie movie) {
        this.updateViewWithMovie(movie);
    }
}
