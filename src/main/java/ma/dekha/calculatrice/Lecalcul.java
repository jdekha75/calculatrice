/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice;

/**
 *
 * @author linux
 */
public class Lecalcul {

    private int p1 = 0;
    private int p2 = 0;
    private double resultat = 0;

    public Lecalcul() {
    }

    public String calculer(String str) {
        String s = retirerParenthese(str) + "";

        return s;
    }

    public double traiter(String str) {

        while (!str.isBlank() && !str.isEmpty() && (str.contains("/") || str.contains("÷") || str.contains("x") || str.contains("×"))) {
            String s;
            int i1 = str.indexOf('/');
            int i2 = str.indexOf('÷');
            int i3 = str.indexOf('x');
            int i4 = str.indexOf('×');

            if (i1 < 0) {
                i1 = Integer.MAX_VALUE;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }

            int positionMin = Math.min(i1, Math.min(i2, Math.min(i3, i4)));
            s = traiter(str, positionMin) + "";
            /*  
            System.out.println(str);
            if (str.contains("x")) {
                s = traiter(str, 'x') + "";
            }
            else {
                s = traiter(str, '×') + "";
            }
             */
            System.out.println(s);

            str = str.substring(0, p1) + s + str.substring(p2, str.length());
        }
        /*
        while (!str.isBlank() && !str.isEmpty() && ())) {
            String s;
            if (str.contains("/")) {
                s = traiter(str, '/') + "";
            }
            else {
                s = traiter(str, '÷') + "";
            }

            str = str.substring(0, p1) + s + str.substring(p2, str.length());
        }
         */
        while (!str.isBlank() && !str.isEmpty() && str.contains("+")) {
            System.out.println(str);
            int position = str.indexOf('+');
            String s = traiter(str, position) + "";
            System.out.println(s);
            str = str.substring(0, p1) + s + str.substring(p2, str.length());
        }
        if (str.startsWith("−")) {
            str = str.replace('−', '-');
        }
        while (!str.isBlank() && !str.isEmpty() && (str.lastIndexOf('-') > 0 || str.lastIndexOf('−') > 0)) {

            int position = Math.max(str.lastIndexOf('-'), str.lastIndexOf('−'));
            String s = traiter(str, position) + "";
            /*
            if (str.contains("-")) {
                s = traiter(str, '-') + "";
            }
            else {
                s = traiter(str, '−') + "";
            }
             */
            str = str.substring(0, p1) + s + str.substring(p2, str.length());
        }

        return Double.valueOf(str);
    }

    public double traiter(String str, int position) {

        char c = str.charAt(position);

        //int pos = Integer.min((int) (Math.abs(pos1)), (int) (Math.abs(pos2)));
        double op1 = operande1(str, position);
        double op2 = operande2(str, position);

        double result = 0;

        switch (c) {
            case 'x':
            case '×':
                result = multiplier(op1, op2);
                break;
            case '/':
            case '÷':
                result = diviser(op1, op2);
                break;
            case '+':
                result = additionner(op1, op2);
                break;
            case '-':
            case '−':
                result = soustraire(op1, op2);
                break;
        }

        return result;
    }

    /**
     * public double parser(String s) { double res = 0;
     *
     * while (!s.isBlank() && !s.isEmpty() && (s.contains("x") ||
     * s.contains("/"))) { res = calculer(s); s = s.substring(0, p1) + res + ""
     * + s.substring(p2, s.length()); }
     *
     * if (s.contains("+") || s.contains("-")) { return calculFinal(s); } else {
     * return Double.parseDouble(s); } }
     */
    /**
     * public double calculer(String str) {
     *
     * int pos1 = str.indexOf("x"); int pos2 = str.indexOf("/"); int pos;
     *
     * if (pos1 >= 0 && pos2 >= 0) { pos = (pos1 < pos2) ? pos1 : pos2; } else
     * if (pos2 < 0) {
     * pos = pos1;
     * }
     * else {
     * pos = pos2;
     * }
     * //int pos = Integer.min((int) (Math.abs(pos1)), (int) (Math.abs(pos2)));
     *
     * double op1 = operande1(str, pos);
     * double op2 = operande2(str, pos);
     *
     * if (pos > 0 && pos == pos1) { return multiplier(op1, op2); } else {
     * return diviser(op1, op2); }
     *
     * //return 16; }
     */
    public double operande1(String str, int position) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String s = "";
        char c = 0;
        boolean moins = false;
        do {
            position--;

            if (position >= 0 && !str.isEmpty()) {
                c = str.charAt(position);

                if (Character.isDigit(c) || c == '.' || c == ',') {
                    s = c + s;
                }
                else if (c == '−' || c == '-') {
                    s = '-' + s;
                    moins = true;
                }
            }

        } while (!moins && position >= 0 && (Character.isDigit(c) || Character.isSpaceChar(c) || c == '.' || c == ','));

        if (moins) {
            p1 = position;
        }
        else {
            p1 = position + 1;
        }
        System.out.println("op1 : " + s);
        if (!s.isEmpty()) {
            return Double.parseDouble(s);
        }
        else {
            return 0.0;
        }
    }

    public double operande2(String str, int position) {

        /*
        ++position;
        String str = "";
        char c = str.charAt(position);

        while (position < str.length() && Character.isDigit(c)) {
            str += c;
            if (position < str.length() - 1) {
                position++;
                c = str.charAt(position);
            }
        }
        p2 = position;
         */
        String s = "";
        char c = 0;
        int signeMoins = 0;
        do {
            position++;

            if (position < str.length() && !str.isEmpty()) {

                c = str.charAt(position);

                if (Character.isDigit(c) || c == '−' || c == '-' || c == '.' || c == ',') {

                    if ((c == '−' || c == '-') && s.isEmpty()) {
                        s += '-';
                        signeMoins++;
                    }
                    else if ((c == '−' || c == '-') && !s.isEmpty()) {

                        signeMoins++;
                    }
                    else {
                        s += c;
                    }

                }
            }
        } while (signeMoins < 2 && position < str.length() && (Character.isDigit(c) || Character.isSpaceChar(c) || c == '−' || c == '-' || c == '.' || c == ','));

        //p2 = Integer.min(str.length() - 1, position);
        p2 = position;
        System.out.println("op2 : " + s);
        if (!s.equals("")) {
            return Double.parseDouble(s);
        }
        else {
            return 0.0;
        }

    }

    public double multiplier(double op1, double op2) {
        return op1 * op2;
    }

    public double diviser(double op1, double op2) {
        return op1 / op2;
    }

    public double additionner(double op1, double op2) {
        return op1 + op2;
    }

    public double soustraire(double op1, double op2) {
        return op1 - op2;
    }

    /**
     * private double calculFinal(String s) {
     *
     * double result = 0; char operateur = '+';
     *
     * int position = 0; int taille = 0; if (s != null && s.length() > 0) { s =
     * s.trim(); taille = s.length();
     *
     * }
     *
     * while (position < taille) {
     *
     * String sch = "";
     *
     * char c = s.charAt(position); while ((c != '+') && (c != '-') && (position
     * < taille)) {
     *
     * sch += c; position++; if (position < taille) { c = s.charAt(position); }
     *
     * }
     *
     * //if (position < taille) double chiffre = Double.parseDouble(sch);
     * System.out.println(chiffre);
     *
     * if (operateur == '+') { result += chiffre; } else { result -= chiffre; }
     *
     * operateur = c; position++;
     *
     * }
     * return result; }
     */
    private String retirerParenthese(String str) {

        while (str.contains("(") && str.contains(")")) {

            int lastOuvr = str.lastIndexOf('(');
            int firstFerm = str.indexOf(')', lastOuvr);

            String s = str.substring(lastOuvr + 1, firstFerm);
            str = str.substring(0, lastOuvr) + traiter(s) + str.substring(firstFerm + 1);
        }

        if (str.contains("(") || str.contains(")")) {

            int position = Integer.max(str.indexOf('('), str.indexOf(')'));
            throw new IllegalArgumentException("manque " + position);
        }

        //str = String.format​("%g", traiter(str));
        str = Double.toString(traiter(str));
        return str;
    }
}
