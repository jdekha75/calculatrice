/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author linux
 */
public class CommandeActionListener implements  ActionListener {

        @Override
    public void actionPerformed(ActionEvent ae) {
        ;
/**
        String str = ae.getActionCommand();

        switch (str) {
            case "=":

                if (!text.isBlank()) {
                    resultat = new Lecalcul().parenthese("(16+67)x(1+2)");
                    fenetreCentre.setText(resultat + "");
//                        jt.setText(resultat + "");
//                        JTextPane jtp = new JTextPane();
//                        jtp.setPreferredSize(new Dimension(500, 40));
//                        jtp.setEditable(false);
//                        jtp.setPreferredSize(new Dimension(500, 40));

                    //jtp.setBackground(new Color(238, 238, 238));
                    //calculsPrecedents.append(text + "\t\t=\t" + resultat + "\n");
                    jtp.setText(text + "\t\t=\t" + resultat + "\n");

                    fenetreNord.add(jtp);
                    //jtp.validate();
                    revalidate();
                    //fenetreNord.setText("\n" + calculsPrecedents.toString() + "\n");
                    System.out.print(calculsPrecedents.toString() + "\n\n");
                    resultat = 0;
                    text = "";
                    operateur = "+";
                }
                break;

            case "+":
                if (!text.isBlank() && !b) {
                    //resultat += Double.parseDouble(text);
                    text += " " + str + " ";
                    fenetreCentre.setText(text);
                    //calcule();
                    operateur = str;
                    //text = "";
                }
                break;

            case "-":
                if (text.isBlank()) {
                    inter += str;
                    text += str;
                    fenetreCentre.setText(text);
                    //calcule();
                }
                else {

                    //calcule();
                    operateur = str;

                    text += " " + str + " ";
                    fenetreCentre.setText(text);
                }

                break;

            case "x":
                if (!text.isBlank() && !b) {
                    //resultat += Double.parseDouble(text);
                    text += " " + str + " ";
                    fenetreCentre.setText(text);
                    //calcule();
                    operateur = str;
                    //text = "";
                }
                break;

            case "/":
                if (!text.isBlank() && !b) {
                    //resultat += Double.parseDouble(text);
                    text += " " + str + " ";
                    fenetreCentre.setText(text);
                    //calcule();
                    operateur = str;
                    //text = "";
                }
                break;

            case ".":
                if (!inter.contains(".")) {
                    Controleur.traite(str);
                break;

        }
        b = true;*/
    }

}
