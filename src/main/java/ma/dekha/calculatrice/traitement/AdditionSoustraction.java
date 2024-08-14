/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.traitement;

/**
 *
 * @author linux
 */
public class AdditionSoustraction {

    public static double additionnerSoustraire(String s) {
        s = s.replace("--", "+");
        double resultat = 0;
        char operateur = '+';

        int position = 0;
        int taille = 0;
        if (s != null && !s.isBlank()) {
            s = s.trim();
            taille = s.length();

        }

        while (position < taille) {

            String sch = "";

            char c = s.charAt(position);
            if (c == '+') {
                position++;

            }
            else if (c == '-') {
                operateur = '-';
                position++;

            }
            if (position >= taille) {
                break;
            }
            c = s.charAt(position);
            while ((c != '+') && (c != '-') && (position < taille)) {

                sch += c;
                position++;
                if (position < taille) {
                    c = s.charAt(position);
                }

            }

            //if (position < taille)
            System.out.println(sch);

            double chiffre = Double.parseDouble(sch);
            System.out.println(chiffre);

            if (operateur == '+') {
                resultat += chiffre;
            }
            else {
                resultat -= chiffre;
            }

            operateur = c;
            position++;

        }
        return resultat;
    }

}
