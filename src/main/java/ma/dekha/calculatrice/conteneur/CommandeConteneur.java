/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

import ma.dekha.calculatrice.controleur.ControleurAffiche;
import ma.dekha.calculatrice.ecouteur.ClavierActionListener;

/**
 * @author linux
 */
public class CommandeConteneur extends JPanel {

    static int x = 0;
    static int y = 0;
    static boolean commande = true;
    GridBagConstraints c;

    public CommandeConteneur() {

        this.setLayout(new GridBagLayout());
        // this.setBackground(new Color(248, 248, 248));
        //this.setBackground(new Color(0, 0, 0));
        //new GridBagLayout().
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        //----- colonne 1-----------------
        ajouterBouton("\u2193n");
        ajouterBouton("7");
        ajouterBouton("4");
        ajouterBouton("1");
        ajouterBouton("0");
        x++;

        //-------------------------------
        //----- colonne 2-----------------
        ajouterBouton("\u2191n");
        ajouterBouton("8");
        ajouterBouton("5");
        ajouterBouton("2");
        ajouterBouton(",");
        x++;

        //----- colonne 3-----------------
        ajouterBouton("×10ʸ");
        ajouterBouton("9");
        ajouterBouton("6");
        ajouterBouton("3");
        ajouterBouton("i");
        x++;

        //----- colonne  4 -----------------
        ajouterBouton("mod");
        //ajouterBouton("÷");
        ajouterBouton("\u00f7");
        ajouterBouton("×");
        //ajouterBouton("x");
        ajouterBouton("−");
        ajouterBouton("+");
        x++;

        //----- colonne  5-----------------
        c.weighty = 1;
        ajouterBouton("\u21B6");
        ajouterBouton("(");
        c.gridwidth = 2;
        c.gridheight = 1;
        c.gridx = x;
        c.gridy = y % 5;
        c.insets = new Insets(3, 3, 0, 0);

        JButton xBouton = new JButton("\u0058");
        //xBouton.setFont(Font.getFont(Font.SANS_SERIF));
        //xBouton.setFont(xBouton.getFont().deriveFont(Font.ITALIC));
        //System.out.println("bouton " + xBouton.getFont().getFontName());
        add(xBouton, c);//ajouterBouton("X");
        y++;
        ajouterBouton("n");
        ajouterBouton("=");
        x++;

        //-----  colonne  6 -----------------
        ajouterBouton("C");
        ajouterBouton(")");
        y++;
        //ajouterBouton("4");
        ajouterBouton("e");
        ajouterBouton("a×b");
        x++;

        //----- colonne  7 -----------------
        c.gridwidth = 4;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = x;
        c.gridy = y % 5;
        c.insets = new Insets(3, 3, 0, 6);

        this.add(ajouter("cos", "sin", "tan"), c);

        y++;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = x;
        c.gridy = y % 5;
        c.insets = new Insets(3, 3, 0, 6);

        this.add(ajouter("cosh", "sinh", "tanh"), c);

        y++;
        ajouterBouton("x\u207B\u00B9");
        ajouterBouton("xʸ");
        ajouterBouton(" Re ");
        x++;
        y++;
        y++;
        ajouterBouton("x!");
        ajouterBouton("\u221a");
        ajouterBouton("Im");
        x++;
        y++;
        y++;
        ajouterBouton("|x|");
        ajouterBouton("log");
        ajouterBouton("conj");
        x++;
        y++;
        y++;
        ajouterBouton("Arg");
        ajouterBouton("ln");
        ajouterBouton("f(x)");
    }

    public static boolean isCommande() {
        return commande;
    }

    public static void setCommande() {
        commande = !commande;
    }

    private void ajouterBouton(String s) {

        if ((x % 10 == 0) && (y % 5 == 0)) {
            c.insets = new Insets(3, 6, 0, 0);
        }
        else if ((x % 10) == 9 && (y % 5 == 0)) {
            c.insets = new Insets(3, 3, 0, 6);
        }
        else if (x % 10 == 0 && y % 5 == 4) {
            c.insets = new Insets(3, 6, 10, 0);
        }
        else if (x % 10 == 0) {
            c.insets = new Insets(3, 6, 0, 0);
        }
        else if ((x % 10) != 0 && (y % 5 == 0)) {
            c.insets = new Insets(3, 3, 0, 0);
        }
        else if ((x % 10) == 9 && (y % 5 == 4)) {
            c.insets = new Insets(3, 3, 10, 6);
        }
        else if ((x % 10) == 9 && (y % 5 != 0)) {
            c.insets = new Insets(3, 3, 0, 6);
        }
        else if ((x % 10) != 0 && (y % 5 == 0)) {
            c.insets = new Insets(3, 3, 0, 0);
        }
        else if ((x % 10) != 0 && (y % 5 == 4)) {
            c.insets = new Insets(3, 3, 10, 0);
        }
        else {
            c.insets = new Insets(3, 3, 0, 0);
        }

        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = x;
        c.gridy = y % 5;

        JButton bouton = new JButton();
        //JToggleButton bouton = new JToggleButton();

        if (s.length() < 3) {
            bouton.setText(" " + s + " ");
        }
        else {
            bouton.setText(s);
        }

        //Font f = new Font("noto sans", Font.PLAIN, 12);
        //bouton.setFont(bouton.getFont().deriveFont(Font.BOLD));
        //bouton.setForeground(new Color(40, 40, 40));
        bouton.setToolTipText(s);
        if (s.contains("=")) {
            bouton.setBackground(new Color(0, 0, 0));
        }

        //bouton.setBackground(new Color(255, 255, 255));
        bouton.setFocusable(false);

        //bouton.setBorder(new MatteBorder(x, WIDTH, ABORT, HEIGHT, Color.yellow));
        add(bouton, c);
        y++;

        bouton.addActionListener(e -> {

            ControleurAffiche.traite(s);
        });
    }

    private void ajouterBouton(int j) {

        for (int i = 0; i < 10; i++) {

            if (i == 0 && j == 0) {
                c.insets = new Insets(0, 6, 3, 3);
            }
            else if (i == 9) {
                c.insets = new Insets(3, 3, 3, 6);
            }
            else if (i == 0 && j != 0) {
                c.insets = new Insets(3, 6, 3, 3);
            }
            else if (i != 0 && j == 0) {
                c.insets = new Insets(0, 3, 3, 3);
            }
            else {
                c.insets = new Insets(3, 3, 3, 3);
            }

            c.gridx = i;

            JButton bouton = new JButton("" + i);

            bouton.setOpaque(true);
            bouton.setForeground(new Color(80, 80, 80));
            bouton.setPreferredSize(new Dimension(55, 50));
            bouton.setBackground(new Color(255, 255, 255));
            bouton.setFocusable(false);
            bouton.setRolloverEnabled(false);
            bouton.setBorderPainted(false);
            //add(bouton, c);

            //bouton.setBorder(new FromMesureBorder() );
        }
    }

    private JPanel ajouter(String... str) {
        JPanel jp = new JPanel(new GridLayout(1, 3, 3, 0));

        for (String s : str) {
            JButton bouton = new JButton(s);
            //bouton.setBorderPainted(false);
            bouton.addActionListener(new ClavierActionListener());
            jp.add(bouton);
        }

        return jp;
    }
}
