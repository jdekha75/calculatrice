/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.dekha.calculatrice.traitement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author linux
 */
public class Fonction {

    public static String traite(String str) {

        double resultat = 0d;
        double res = 0d;
        int p1;
        int p2;

        String regExp = "(\\p{Alpha}{2,}) *\\(? *(-?\\d+(\\.\\d+)?(E\\d+)?) *\\)?";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        System.out.println(str);
        if (!matcher.find()) {
            return str;
        }
        else {
            matcher.reset();
        }

        while (!str.isBlank() && !str.isEmpty() && matcher.find()) {
            String nomFonction = matcher.group(1);
            String param = matcher.group(2);
            System.out.println(nomFonction);
            System.out.println(param);

            p1 = matcher.start();
            p2 = matcher.end();

            switch (nomFonction) {
                case "cos", "sin", "tan" ->  {
                    double d = Double.valueOf(param);
//                    d = d * Math.PI / 180;
                    d = Math.toRadians(d);
                    param = d + "";
                }

                case "ln" -> nomFonction = "log";

                case "log" -> nomFonction = "log10";
            }
            /*
             switch (nomFonction) {
                case "cos", "sin", "tan": {
                    double d = Double.valueOf(param);
//                    d = d * Math.PI / 180;
                    d = Math.toRadians(d);
                    param = d + "";
                    break;
                }

                case "ln":
                    nomFonction = "log";
                    break;

                case "log":
                    nomFonction = "log10";
                    break;
            }
            */

            String s = sousTraite(nomFonction, param);
            str = str.substring(0, p1) + s + str.substring(p2, str.length());
            matcher = pattern.matcher(str);

        }
        return str;
    }

    private static String sousTraite(String nomFonction, String param) {
        String str = null;
        double paramDouble = Double.valueOf(param);

        Class classe = Math.class;
        try {
            Method methode = classe.getMethod(nomFonction, double.class);
            try {
                str = (Double) methode.invoke(null, paramDouble) + "";
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
        }
        return str;
    }
}
