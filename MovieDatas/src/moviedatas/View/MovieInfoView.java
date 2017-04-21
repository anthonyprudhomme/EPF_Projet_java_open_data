/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author anthony
 */
public class MovieInfoView {
    public JPanel createInfoPanel() {
        JPanel infoPanel = new JPanel();
        JLabel labelPanel = new JLabel("Informations");
        
        infoPanel.add(labelPanel);
        
        return infoPanel;
    }
}
