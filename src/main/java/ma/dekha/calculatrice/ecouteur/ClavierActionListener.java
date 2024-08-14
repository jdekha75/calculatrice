/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ma.dekha.calculatrice.controleur.ControleurAffiche;

/**
 *
 * @author linux
 */
public class ClavierActionListener implements ActionListener {

    String str;

    public ClavierActionListener() {

    }

    public ClavierActionListener(String str) {
        this.str = str;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("-")) {
            ControleurAffiche.traite("−");
        }
        else if (ae.getActionCommand().equals("*")) {
            ControleurAffiche.traite("×");
        }
        else if (ae.getActionCommand().equals("x")) {
            ControleurAffiche.traite("×");
        }
        else if (ae.getActionCommand().equals(".")) {
            ControleurAffiche.traite(",");
        }
        else if (ae.getActionCommand().equals("/")) {
            ControleurAffiche.traite("÷");
        }

        //else if (ae.getActionCommand().equals("\n")) {
        else if (ae.getActionCommand().equals(System.lineSeparator())) {
            ControleurAffiche.traite("=");
        }
        else {
            ControleurAffiche.traite(ae.getActionCommand());
        }
    }
}
