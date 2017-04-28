/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import javafx.scene.control.CheckBox;
import moviedatas.Log;

public class JComboCheckBox extends JComboBox {
    
    private ArrayList<String> selectedValues = new ArrayList<>();
    private Component[] comboBoxes = null;
    
    public JComboCheckBox() {
        addStuff();
    }

    public JComboCheckBox(JCheckBox[] items) {
        super(items);
        addStuff();
    }

    public JComboCheckBox(Vector items) {
        super(items);
        addStuff();
    }

    public JComboCheckBox(ComboBoxModel aModel) {
        super(aModel);
        addStuff();
    }

    private void addStuff() {
        setRenderer(new ComboBoxRenderer());
        
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                itemSelected();
            }
        });
    }

    private void itemSelected() {
        if (getSelectedItem() instanceof JCheckBox) {
            JCheckBox jcb = (JCheckBox)getSelectedItem();
            jcb.setSelected(!jcb.isSelected());
        }
    }

    private void setCheckBoxList(Component[] parent) {
        Log.e("In the method");
        Log.e("Parent size: "+ parent.length);
        this.comboBoxes = parent;
    }
    
    class ComboBoxRenderer implements ListCellRenderer {
        private JLabel defaultLabel;

        public ComboBoxRenderer() {
            setOpaque(true);
        }
    
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component c = (Component)value;
                if (isSelected) {
                    c.setBackground(list.getSelectionBackground());
                    c.setForeground(list.getSelectionForeground());
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }
                return c;
            } else {
            if (defaultLabel==null) defaultLabel = new JLabel(value.toString());
            else defaultLabel.setText(value.toString());
            return defaultLabel;
            }
        }
    }
    
    public ArrayList<String> getSelectedValues(){
        Object unknownItem = getSelectedItem();
//        Log.e("Enfant : "+((JCheckBox) unknownItem).getComponentCount());
//        Log.e("Parent : "+((JCheckBox) unknownItem).getParent().getComponentCount());
        if (unknownItem instanceof JCheckBox) {
            JCheckBox currentCheckBox = (JCheckBox) unknownItem;
            if (this.comboBoxes == null) {
                this.setCheckBoxList(currentCheckBox.getParent().getComponents());
            }
            if(!currentCheckBox.isSelected()){
                selectedValues.add((currentCheckBox.getText()));
            }else{
                selectedValues.remove(currentCheckBox.getText());
            }
        } else {
            selectedValues.clear();
            selectedValues.add("All");

            for (int i = 1; i < this.comboBoxes.length; i++) {
                JCheckBox currentCheckBox = (JCheckBox)this.comboBoxes[i];
                if(currentCheckBox.isSelected()){
                    currentCheckBox.setSelected(false);
                }
                //((JCheckBox) unknownItem).getParent();
                //Log.e("Enfant "+((JComboCheckBox)this.getComponents()[i].getParent()).);
//                Log.e(((JCheckBox)this.getComponent(i)).isSelected());
//                Log.e(this.getParent());
//                Log.e("Parent "+this.getComponents()[i].getParent());
//                Log.e("Number of component "+this.getComponents()[i].getParent().getComponentCount());
            }
        }
        
        Log.e("-------");
        for (int i = 0; i < selectedValues.size(); i++) {
            Log.e(selectedValues.get(i));
        }
        return selectedValues;
    }
}