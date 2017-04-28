/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import javafx.util.Pair;
import javax.swing.JPanel;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Log;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class SpiderChartView implements MovieInfoControllerInterface {

    private SpiderWebChart spiderChart;
    public static MovieInfoControllerInterface observer;

    public JPanel initView() {
        observer = this;
        spiderChart = new SpiderWebChart(
                "", 0, 0, 0, 0, 0);
        JPanel chartPanel = new JPanel();
        spiderChart.getPanel().setPreferredSize(new Dimension(400,300));
        chartPanel.add(spiderChart.getPanel());
        return chartPanel;
    }

    @Override
    public void newMovieSelected(Movie movie) {
        int duration;
        double ratio;
        double score;
        double recency;
        int fbLikes;
        duration = (int)(100 * (-((float) movie.getDuration() / 200) + 1));
        if (duration == 0) {
            duration = 1;
        }
        if (movie.getGross() != 0) {
            ratio = 100 * ((-((float)movie.getBudget() / movie.getGross()) / 10) + 1);
            if (ratio == 0) {
                ratio = 1;
            }
        }else{
            ratio = 1;
        }
        score = 100 * (-(movie.getScore() / 300) + 1);
        if (score == 0) {
            score = 1;
        }
        recency = 100 * ((-((float)movie.getReleaseYear() - 1900) / 117) + 1);
        if (recency == 0) {
            recency = 1;
        }
        fbLikes = 100 * ((-(movie.getFbLikes()) / 100000) + 1);
        if (fbLikes == 0) {
            fbLikes = 1;
        }
        Log.e(duration + " " + movie.getScore()+ " | " + ratio + " " + movie.getBudget()+ " " + movie.getGross()+ " | " +score+ " " + movie.getScore() + " | " + recency + " " + movie.getReleaseYear() + " | " + fbLikes + " " + movie.getFbLikes());
        spiderChart.refreshChart(spiderChart.getPanel(), duration, ratio, score, recency, fbLikes);
    }

}
