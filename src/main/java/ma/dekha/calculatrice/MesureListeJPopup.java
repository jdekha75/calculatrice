/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author linux
 */
public class MesureListeJPopup {

    //private static JButton fromMesure;
    //private static JButton toMesure;
    private static int index = 0;
    private static JMenu[] tableauJMenu;
    private static JPopupMenu jpopupFrom;
    private JPopupMenu jpopupTo;
    static int x = 0;
    static int y = 0;

    private static final JMenuItem[][] tableauJMenuItemses = new JMenuItem[8][];
    private static MesureListeJPopup mesureLIste = new MesureListeJPopup();

    public MesureListeJPopup() {

        jpopupFrom = new JPopupMenu();
        jpopupTo = new JPopupMenu();

        JMenu angle = new JMenu("Angle");
        angle.setMnemonic('L');
        JMenu longueur = new JMenu("Longueur");
        longueur.setMnemonic('G');
        JMenu surface = new JMenu("Surface");
        surface.setMnemonic('F');
        JMenu volume = new JMenu("Volume");
        volume.setMnemonic('M');
        JMenu poid = new JMenu("Poid");
        poid.setMnemonic('P');
        JMenu duree = new JMenu("Durée");
        duree.setMnemonic('R');
        JMenu temperature = new JMenu("Temperature");
        temperature.setMnemonic('P');
        JMenu stockage = new JMenu("Stockage Digital");
        stockage.setMnemonic('K');
        tableauJMenu = new JMenu[]{angle, longueur, surface, volume, poid, duree, temperature, stockage};

        JMenuItem degres = new JMenuItem("Degres", 'D');
        degres.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
        JMenuItem radians = new JMenuItem("Radians", 'R');
        radians.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        JMenuItem gradians = new JMenuItem("Gradians", 'G');
        gradians.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));

        tableauJMenuItemses[0] = new JMenuItem[]{degres, radians, gradians};

        JMenuItem parsec = new JMenuItem("cm");
        JMenuItem anneeLumiere = new JMenuItem("Année Lumière");
        JMenuItem astraunomique = new JMenuItem("Métre");
        JMenuItem nautique = new JMenuItem("Métre");
        JMenuItem miles = new JMenuItem("Kilooctet");
        JMenuItem pied = new JMenuItem("cm");
        JMenuItem cm = new JMenuItem("centmMétre");
        JMenuItem metre = new JMenuItem("Métre");
        tableauJMenuItemses[1] = new JMenuItem[]{parsec, anneeLumiere, astraunomique, nautique, miles, pied, cm, metre};

        JMenuItem giga = new JMenuItem("Gigaoctet");
        JMenuItem mega = new JMenuItem("Megaoctet");
        JMenuItem kilo = new JMenuItem("Kilooctet");
        tableauJMenuItemses[2] = new JMenuItem[]{giga, mega, kilo};

        JMenuItem hectare = new JMenuItem("Hectare");
        JMenuItem km2 = new JMenuItem("Km carré");
        JMenuItem m2 = new JMenuItem("Métre carré");
        JMenuItem cm2 = new JMenuItem("Centimétre carré");
        tableauJMenuItemses[3] = new JMenuItem[]{hectare, km2, m2, cm2};

        tableauJMenuItemses[4] = new JMenuItem[]{};
        tableauJMenuItemses[5] = new JMenuItem[]{};
        tableauJMenuItemses[6] = new JMenuItem[]{};
        tableauJMenuItemses[7] = new JMenuItem[]{};

        //new MesureListeJPopup();
        jpopupFrom.setPopupSize(190, 250);
        jpopupTo.setPopupSize(200, 250);
        // jpopupFrom.setBackground(new Color(255, 255, 250));
        //jpopupFrom.revalidate();

        jpopupFrom.getSubElements();

        remplirJPopupFrom();
        ajouterJMenuItem();
        for (JMenu jmenu : tableauJMenu) {
            //System.out.println((int) (jmenu.getLocation().getX()) + " " + (int) (jmenu.getLocation().getY()));//.setBackground(Color.red);
        }
        ajouterListener();

    }

    private static void remplirJPopupFrom() {

        for (JMenu jmenu : tableauJMenu) {

            jpopupFrom.add(jmenu);

        }

    }

    private void ajouterJMenuItem() {
        int i = 0;
        for (JMenu jmenu : tableauJMenu) {

            jmenu.setPreferredSize(new Dimension(190, 30));
            jmenu.setBorderPainted(false);
            jmenu.setBackground(Color.WHITE);

            for (int j = 0; j < tableauJMenuItemses[i].length; j++) {
                jmenu.add(tableauJMenuItemses[i][j]);
            }
            i++;

            jmenu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    jmenu.setBackground(new Color(255, 255, 250));
                    x = (int) (jmenu.getLocation().getX());
                    y = (int) (jmenu.getLocation().getY());
                    System.out.println(x + " " + y);

                    //JMenu j = (JMenu) o;
                    //j.setBackground(Color.red);
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }

    }

    private void ajouterListener() {
        //for (JMenuItem[] jmenu : tableauJMenuItemses) {
        //for (JMenuItem jm : jmenu) {
        for (int i = 0; i < tableauJMenuItemses.length; i++) {
            for (JMenuItem jm : tableauJMenuItemses[i]) {

                jm.addActionListener(e -> {
                    JMenuItem j = ((JMenuItem) (e.getSource()));
                    //index = i;
                    //System.out.println("com.m "+ jpopupFrom.getInvoker());
                    Component c = jpopupFrom.getInvoker();
                    JButton fromMesure = (JButton) c;
                    fromMesure.setText(jm.getText());
                    //System.out.println("com.m "+ fromMesure);
                }
                );
            }
        }

    }

    public static void showup(Component c) {

        //System.out.println(x + " " + y);
        jpopupFrom.show(c, x, y * -1);
        //PopUpFactory.show().show(c, x, y);

    }
}
