/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.ecouteur;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author linux
 */
public class ToMouseListener extends MouseAdapter {

    Color c;
    boolean b;

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        c = ((JButton) (e.getSource())).getBackground();
        JButton to = (JButton) (e.getSource());

        to.setBackground(Color.WHITE);
        to.getGraphics().setColor(new Color(129, 166, 142));
        to.setBorderPainted(true);
        //to.setBorder(new LineBorder(new Color(230, 230, 0), 5));
        // to.getParent().repaint();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JButton) (e.getSource())).setBackground(c);
        ((JButton) (e.getSource())).setBorderPainted(false);
        //((JButton)(e.getSource())).

    }

}
