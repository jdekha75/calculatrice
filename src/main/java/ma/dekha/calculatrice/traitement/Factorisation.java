package ma.dekha.calculatrice.traitement;

import java.time.Duration;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factorisation {

    public static String factorise(String str) {

        Pattern pattern = Pattern.compile("(\\d+)(\\.0+)?");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        else {
            throw new IllegalArgumentException("entier");
        }

        LocalTime debut = LocalTime.now();
        //   Instant ins = Instant.now();

        //System.out.println(debut);
        long l = Long.parseLong(str);
        StringBuilder sb = new StringBuilder();
//        String s = l + "";
//        String str = "";
        long i = 2;
        if (l % i != 0) {
            i++;
        }
        long reste = l;

        //long inter = l / 2;
        while (reste > i) {
            reste = l / i;

            if (l % i == 0) {
                l = reste;
//                str = str + i + "x";
                sb.append(i).append("x");
                System.out.println(sb.toString());
            }
            else if (i != 2) {
                i += 2;
            }
            else {
                i++;
            }
        }

//        str = str + l;
        sb.append(l);
        long ll = LocalTime.now().toNanoOfDay() - debut.toNanoOfDay();
        //System.out.println(ll);
        // System.out.println(debut.plusNanos(ll));
        System.out.println(Duration.ofNanos(ll));

        return sb.toString();
    }
}
