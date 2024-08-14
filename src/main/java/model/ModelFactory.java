/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 *
 * @author linux
 */
public class ModelFactory {

    private static Map<String, List<JMenuItem>> mesureListe;
    private static List<JMenu> listeJMenu;
    private static Map<String, JPopupMenu> listeJpopup;
    private static JPopupMenu menuFromPopUp;
    private static String menuSelectionne;

    public ModelFactory() {

        mesureListe = new HashMap<>();
        listeJMenu = new ArrayList<>();
        listeJpopup = new HashMap<>();
        menuFromPopUp = new JPopupMenu();

        menuFromPopUp.setPopupSize(190, 250);
        menuFromPopUp.setBackground(new Color(255, 255, 250));
        menuFromPopUp.setFocusable(false);

        /**
         * ******************************************
         */
        List<JMenuItem> angle = new ArrayList<>();

        JMenuItem degres = new JMenuItem("Degres", 'D');
        degres.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
        JMenuItem radians = new JMenuItem("Radians", 'R');
        radians.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        JMenuItem gradians = new JMenuItem("Gradians", 'G');
        gradians.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));

        ajouterJMenuItem("Angle", angle, degres, radians, gradians);

        /**
         * ******************************************
         */
        List<JMenuItem> longueur = new ArrayList<>();

        JMenuItem parsec = new JMenuItem("Parsec");
        JMenuItem anneeLumiere = new JMenuItem("Année Lumière");
        JMenuItem astronomique = new JMenuItem("Astronomique");
        JMenuItem nautique = new JMenuItem("Nautique");
        JMenuItem miles = new JMenuItem("Miles");
        JMenuItem pied = new JMenuItem("Pied");
        JMenuItem cm = new JMenuItem("centmMétre");
        JMenuItem metre = new JMenuItem("Métre");

        ajouterJMenuItem("Longueur", longueur, parsec, anneeLumiere, astronomique, nautique, miles, pied, cm, metre);

        /**
         * **************************************************
         */
        List<JMenuItem> surface = new ArrayList<>();

        JMenuItem hectare = new JMenuItem("Hectare");
        JMenuItem km2 = new JMenuItem("Km carré");
        JMenuItem m2 = new JMenuItem("Métre carré");
        JMenuItem cm2 = new JMenuItem("Centimétre carré");

        ajouterJMenuItem("Surface", surface, hectare, km2, m2, cm2);

        /**
         * **************************************************
         */
        List<JMenuItem> volume = new ArrayList<>();

        JMenuItem metreCube = new JMenuItem("M");
        JMenuItem litre = new JMenuItem("Litre");
        JMenuItem gallon = new JMenuItem("US Gallon");
        JMenuItem quarts = new JMenuItem("Métre carré");
        JMenuItem pint = new JMenuItem("Centimétre carré");
        JMenuItem millilitre = new JMenuItem("Millilitre");
        JMenuItem microLitre = new JMenuItem("Micro Litre");

        ajouterJMenuItem("Volume", volume, metreCube, litre, gallon, quarts, pint, millilitre, microLitre);

        /**
         * **************************************************
         */
        List<JMenuItem> poid = new ArrayList<>();

        JMenuItem tonne = new JMenuItem("Tonne");
        JMenuItem kilogramme = new JMenuItem("Kg");
        JMenuItem gramme = new JMenuItem("US Gallon");
        JMenuItem milligrame = new JMenuItem("Mg");
        JMenuItem pounds = new JMenuItem("Pound");
        JMenuItem ounce = new JMenuItem("Ounce");
        JMenuItem stone = new JMenuItem("Stone");

        ajouterJMenuItem("Poid", poid, tonne, kilogramme, gramme, milligrame, pounds, ounce, stone);

        /**
         * **************************************************
         */
        List<JMenuItem> duree = new ArrayList<>();

        JMenuItem annee = new JMenuItem("Année");
        JMenuItem mois = new JMenuItem("Mois");
        JMenuItem jour = new JMenuItem("Jour");
        JMenuItem heure = new JMenuItem("Heure");
        JMenuItem minute = new JMenuItem("Minute");
        JMenuItem seconde = new JMenuItem("Seconde");
        JMenuItem milliseconde = new JMenuItem("Milliseconde");
        JMenuItem microseconde = new JMenuItem("Microeconde");

        ajouterJMenuItem("Durée", duree, annee, mois, jour, heure, minute, seconde, milliseconde, microseconde);
        /**
         * **************************************************
         */

        List<JMenuItem> temperature = new ArrayList<>();

        JMenuItem celsius = new JMenuItem("Celsius");
        JMenuItem fahrenheit = new JMenuItem("Fahrenheit");
        JMenuItem kalvin = new JMenuItem("Kalvin");
        JMenuItem rankin = new JMenuItem("Rankin");

        ajouterJMenuItem("temperature", temperature, celsius, fahrenheit, kalvin, rankin);

        /**
         * **************************************************
         */
        List<JMenuItem> digitale = new ArrayList<>();

        JMenuItem bit = new JMenuItem("Bit");
        JMenuItem octet = new JMenuItem("Octet");
        JMenuItem kilo = new JMenuItem("Kilooctet");
        JMenuItem mega = new JMenuItem("Megaoctet");
        JMenuItem giga = new JMenuItem("Gigaoctet");
        JMenuItem tera = new JMenuItem("Teraoctet");

        ajouterJMenuItem("Digitale", digitale, bit, octet, kilo, mega, giga, tera);
        /**
         * **************************************************
         */

        List<JMenuItem> Monnaie = new ArrayList<>();

        /**
         * **************************************************
         */
        //ajouterMenuListener();
    }

    public List<JMenu> getListeJmenu() {
        return listeJMenu;
    }

    public static Map<String, List<JMenuItem>> getJmenuMap() {
        return mesureListe;
    }

    public static JPopupMenu getMenuPopUp() {
        return menuFromPopUp;
    }

    private static void ajouterJMenuItem(String label, List<JMenuItem> l, JMenuItem... jm) {

        JMenu jmenu = new JMenu(label);
        jmenu.setPreferredSize(new Dimension(190, 30));
        jmenu.setBorderPainted(false);
        jmenu.setBackground(new Color(255, 255, 250));
        //jmenu.setFocusable(false);

        for (int i = 0; i < jm.length; i++) {

            jm[i].setBackground(new Color(255, 255, 250));
            jm[i].setPreferredSize(new Dimension(190, 30));
            l.add(jm[i]);
            //ajouterActionListener(jm[i]);
            jmenu.add(jm[i]);

            // ajouterActionListener(jm[i]);
        }

        mesureListe.put(label, l);
        listeJMenu.add(jmenu);
        //listeJpopup.put(l + "", jpop);

    }

    /*
    private static void ajouterMenuListener() {
        listeJMenu.forEach(jmenu -> jmenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                jmenu.setBackground(new Color(255, 255, 250));
                x = (int) (jmenu.getLocation().getX());
                y = (int) (jmenu.getLocation().getY());
                menuSelectionne = jmenu.getName();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }));
    }

    private static void ajouterPopUp() {
        listeJMenu.forEach(jmenu -> menuFromPopUp.add(jmenu));
    }

    public static JPopupMenu show() {
        return menuFromPopUp;//.show(null, 5, 5);
    }
    
    private static void ajouterActionListener(JMenuItem jm) {
        jm.addActionListener(e -> {
            JMenuItem j = ((JMenuItem) (e.getSource()));
            //index = i;
            //System.out.println("com.m "+ jpopupFrom.getInvoker());
            Component c = menuFromPopUp.getInvoker();
            JButton menuDepart = (JButton) c;
            menuDepart.setText("   " + jm.getText());
            System.out.println(" affich " + jm.getText());
        }
        );
    }
     */
}
