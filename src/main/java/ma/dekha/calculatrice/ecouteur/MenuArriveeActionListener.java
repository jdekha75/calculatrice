/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ma.dekha.calculatrice.Fenetre;

/**
 *
 * @author linux
 */
public class MenuArriveeActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Fenetre.afficheMenuArriveePopUp(e);

    }

}
