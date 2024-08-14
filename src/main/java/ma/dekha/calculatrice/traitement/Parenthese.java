/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.traitement;

import ma.dekha.calculatrice.controleur.ControleurCalcul;

/**
 *
 * @author linux
 */
public class Parenthese {

    public static String retireParenthese(String str) {

        if (!str.isEmpty()) {

            str = str.trim();
            str = str.replace(" ", "");
            str = str.replace("\t", "");
            str = str.replace('x', '*');
            str = str.replace('×', '*');
            str = str.replace('÷', '/');
            str = str.replace('−', '-');
            str = str.replace("−−", "+");
            str = str.replace("+−", "-");
            str = str.replace("−+", "-");
            str = str.replace(",", ".");

            //str = str.replace(' ', '-');
            str = str.replace(',', '.');

        }

        while (str.contains("(") && str.contains(")")) {

            int lastOuvr = str.lastIndexOf('(');
            int firstFerm = str.indexOf(')', lastOuvr);

            String s = str.substring(lastOuvr + 1, firstFerm);
            str = str.substring(0, lastOuvr) + ControleurCalcul.traite(s) + str.substring(firstFerm + 1);
        }

        if (str.contains("(") || str.contains(")")) {

            int position = Integer.max(str.indexOf('('), str.indexOf(')'));
            throw new IllegalArgumentException("manque " + position);
        }

        // double result = traiter(str);
        //str = String.format("%,.4g", result);
        return str;
    }

    public static int positionFermante(String str, int i) {

        int position = i;
        int flag = 1;
        while (++i < str.length() && flag != 0) {
            if (str.charAt(i) == ')') {
                position = i;
                flag--;
            }
            else if (str.charAt(i) == '(') {
                flag++;
                positionFermante(str, i);
            }

        }
        if (flag == 0) {
            return position;
        }
        else {
            return -1;
        }
    }

    public static int positionOuvrante(String str, int i) {

        int position = i;
        int flag = 1;
        while (--i >= 0 && flag != 0) {
            if (str.charAt(i) == '(') {
                position = i;
                flag--;
            }
            else if (str.charAt(i) == ')') {
                flag++;
                positionFermante(str, i);
            }

        }
        if (flag == 0) {
            return position;
        }
        else {
            return -1;
        }
    }
}
