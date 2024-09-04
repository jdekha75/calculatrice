/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.controleur;

import ma.dekha.calculatrice.traitement.*;

import java.text.DecimalFormat;

/**
 *
 * @author linux
 */
public class ControleurCalcul {

    private static int p1 = 0;
    private static int p2 = 0;
    private double resultat = 0;


    public ControleurCalcul() {
    }

    public static String calcule(String str) {
        str = insereCaret(str);
        str = Puissance.traitePuissance(str);
        str = Parenthese.retireParenthese(str);
        str = Fonction.traite(str);

        str = traite(str) + "";
        return str;
    }

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    public static double traite(String str) {
        str = MultiplicationDivision.traiter(str);
        str = str.replace("--", "+");
        str = str.replace("-+", "-");
        str = str.replace("+-", "-");
        System.out.println("avant calcul fin");
        str = String.format("%.9f", AdditionSoustraction.additionnerSoustraire(str));

        return Double.valueOf(str);
    }

    /*
    Changer le typescript (puissance) par un ^

     */
    static private String insereCaret(String str) {

        int position = 0;
        int taille;

        StringBuilder strBuild = new StringBuilder();

        if (str != null && !str.isEmpty()) {
            str = str.trim();
            taille = str.length();
        }
        else {
            return null;
        }

        while (position < taille) {

            while (position < taille && !ControleurAffiche.isSuperScript(str.charAt(position) + "")) {
                //while (position < taille && !Character.isDigit(str.charAt(position))) {
                strBuild.append(str.charAt(position));
                position++;
            }

            if (position < taille) {
                str = str.substring(0, position) + "^" + str.substring(position);
                strBuild.append("^");
                taille = str.length();
                position++;
            }

            String s = null;

            while (position < taille && ControleurAffiche.isSuperScript(str.charAt(position) + "")) {
                //while (position < taille && Character.isDigit(str.charAt(position))) {
                char c = str.charAt(position);
                //str = str.substring(taille, taille)
                s = ControleurAffiche.getSupScript(c + "");
                strBuild.append(s);
                position++;
            }

            str = str.substring(0, position) + "@" + str.substring(position);
            taille = str.length();
            position++;
            if (s != null) {
                strBuild.append("@");
            }
        }
        //return str;
        return strBuild.toString();
    }

    public static String factorise(String text) {
        return Factorisation.factorise(text);
    }
}
