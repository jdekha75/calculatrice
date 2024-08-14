/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.controleur;

import java.util.HashMap;
import java.util.Map;
import ma.dekha.calculatrice.Fenetre;

/**
 *
 * @author linux
 */
public class ControleurAffiche {

    public static final Map<String, String> superScriptMap = new HashMap<>();
    private static final Map<String, String> subScriptMap = new HashMap<>();

    private static boolean superScript = false;
    private static boolean subrScript = false;
    private static boolean premier = false;
    private static boolean fonction = false;
    private static boolean deuxMoins = false;
    private static String operateur = "+×÷";

    private static String dernier = "";
    private static String lastString = "";
    private static String mantisse = "";
    private static String exposant = "";

    private static String chaine = "";

    static {
        superScriptMap.put("0", "\u2070");
        superScriptMap.put("1", "\u00B9");
        superScriptMap.put("2", "\u00B2");
        superScriptMap.put("3", "\u00B3");
        superScriptMap.put("4", "\u2074");
        superScriptMap.put("5", "\u2075");
        superScriptMap.put("6", "\u2076");
        superScriptMap.put("7", "\u2077");
        superScriptMap.put("8", "\u2078");
        superScriptMap.put("9", "\u2079");
        //superScriptMap.put("(", "\u207D");
        //superScriptMap.put(")", "\u207E");
        //superScriptMap.put("+", "\u207A");
        //superScriptMap.put("−", "\u207B");
        //superScriptMap.put("×", "*");
        //superScriptMap.put("x", "*");
        //superScriptMap.put("*", "*");

        subScriptMap.put("0", "\u2080");
        subScriptMap.put("1", "\u2081");
        subScriptMap.put("2", "\u2082");
        subScriptMap.put("3", "\u2083");
        subScriptMap.put("4", "\u2084");
        subScriptMap.put("5", "\u2085");
        subScriptMap.put("6", "\u2086");
        subScriptMap.put("7", "\u2087");
        subScriptMap.put("8", "\u2088");
        subScriptMap.put("9", "\u2089");
    }

    public static void traite(String str) {
        str = str.trim();

        //if (superScriptMap.containsKey(str))
        dernier = lastString;
        lastString = str;
        //superScript

        if (str.equals("\u2191n")) {
            if (superScript) {
                if (!mantisse.isEmpty()) {
                    chaine = mantisse;
                }
                if (!exposant.isEmpty()) {
                    chaine += "pow " + exposant;
                }
            }
            superScript = !superScript;
            subrScript = false;
            return;
        }
        //subrScript
        if (str.equals("\u2193n")) {
            subrScript = !subrScript;
            superScript = false;
            return;
        }

        if (str.equals("=")) {

            lastString = mantisse = exposant = "";
            superScript = false;
            String s = Fenetre.getText();
            if (!s.isEmpty()) {
                s = s.trim();
                s = s.replace(" ", "");
                s = s.replace("\t", "");
                s = s.replace('x', '*');
                s = s.replace('×', '*');
                s = s.replace('÷', '/');
                s = s.replace('−', '-');
                s = s.replace("−−", "+");
                s = s.replace("+−", "-");
                s = s.replace("−+", "-");
                s = s.replace(",", ".");

                //str = str.replace(' ', '-');
                s = s.replace(',', '.');
            }
            //Fenetre.clear();
            Fenetre.affiche(new ControleurCalcul().calcule(s));
            return;
        }

        //undo text
        if (str.equals("\u21B6")) {
            Fenetre.undo();
            return;
        }

        //Clear text
        if (str.equals("C")) {
            Fenetre.clear();
            lastString = mantisse = exposant = "";
            superScript = false;
            return;
        }

        if ((mantisse.equals("−") && str.equals("−")) || (exposant.equals("−") && str.equals("−"))) {
            return;
        }

        if ((superScript && str.equals(",")) || (str.equals(",") && mantisse.contains(","))) {
            return;
        }

        while ((operateur.contains(dernier) && operateur.contains(str)) || (operateur.contains(str) && dernier.equals("−"))) {
            return;
        }

        if (superScript) {

            if (mantisse.isBlank()) {
                return;
            }

            if (Character.isDigit(str.charAt(0)) || str.equals("(")) {
                exposant += str;
                str = superScriptMap.get(str);
                Fenetre.affiche(str);
                return;
            }

            if (exposant.isEmpty() && str.equals("−")) {
                exposant += str;
                str = superScriptMap.get(str);
                Fenetre.affiche(str);
                return;
            }

            if (!exposant.isEmpty() && str.equals("÷")) {
                superScript = false;
                Fenetre.affiche(str);
                return;
            }

            if (str.equals("−") && dernier.equals("−") && !deuxMoins) {
                exposant += str;
                str = superScriptMap.get(str);
                Fenetre.affiche(str);
                deuxMoins = true;
                return;
            }

            if (str.equals("−") && dernier.equals("−")) {
                return;
            }

            exposant += str;
            str = superScriptMap.get(str);
            Fenetre.affiche(str);
            deuxMoins = false;
            return;
        }

        if (str.equals("×10ʸ")) {
            if (!mantisse.isEmpty() && !isFct(mantisse)) {
                Fenetre.affiche("×10");
                mantisse += "×10";
            }
            else if (!mantisse.isEmpty() && isFct(mantisse)) {
                Fenetre.affiche("1×10");
                mantisse += "1×10";
            }
            else {
                Fenetre.affiche("×10");
                mantisse = "1×10";
            }
            superScript = true;
            subrScript = false;
            deuxMoins = false;
            return;
        }

        if (str.equals("−") && lastString.equals("−") && !deuxMoins) {
            deuxMoins = true;
            mantisse += str;
            Fenetre.affiche(str);
            return;
        }

        if (!str.equals("−") && str.equals(dernier) && operateur.contains(str) && operateur.contains(str)) {
            return;
        }

        if (str.equals("(") && !dernier.isEmpty() && Character.isDigit(dernier.charAt(0))) {
            mantisse += "×" + str;
        }
        mantisse += str;
        deuxMoins = false;
        Fenetre.affiche(str);
    }

    private static boolean isFct(String str) {
        return str.trim().equals("log");
    }

    public static boolean isSupScript(String str) {
        return superScriptMap.containsValue(str);
    }

    public static String getSupScript(String str) {
        Map<String, String> superScr = new HashMap<>();
        superScriptMap.forEach((key, value) -> {
            superScr.put(value, key);
        });
        return superScr.get(str);
    }
}
