/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author linux
 */
public class PopUp {

    private int xDepart = 0;
    private int yDepart = 0;
    private int xArrivee = 0;
    private int yArrivee = 0;

    private List<JMenu> jmenuListe;
    private Map<String, List<JMenuItem>> jmenuItemMap;

    private JPopupMenu jpopup;

    private JPopupMenu actifJpopup;

    private JPopupMenu angleJpopup;
    private JPopupMenu longueurJpopup;
    private JPopupMenu surfaceJpopup;

    String menuSelectionne;

    public PopUp() {
        jmenuListe = new ModelFactory().getListeJmenu();
        jmenuItemMap = new ModelFactory().getJmenuMap();
        jpopup = new JPopupMenu();

        jpopup.setPopupSize(190, 300);
        jpopup.setBackground(new Color(250, 250, 250));
        jpopup.setFocusable(false);
        jpopup.setBorderPainted(false);

        angleJpopup = new JPopupMenu();
        longueurJpopup = new JPopupMenu();
        surfaceJpopup = new JPopupMenu();

        actifJpopup = new JPopupMenu();;
        actifJpopup.setBorderPainted(false);
        ajouterPopUp();

//        ajouterJpop(angleJpopup, "Angle");
//        ajouterJpop(longueurJpopup, "Longueur");
//        ajouterJpop(surfaceJpopup, "Surface");
//        ajouterMenuListener();
//        ajouterActionListener();
        //ajouter();
        //ajouterActionListener();
    }

    public void showDepart(ActionEvent e) {

        jpopup.show((Component) e.getSource(), xDepart, yDepart * -1);
    }

    public void showArrivee(ActionEvent e) {

        actifJpopup.show((Component) e.getSource(), xArrivee, yArrivee * -1);
    }

    private void ajouterPopUp() {
        jmenuListe.forEach(jmenu -> {

            jpopup.add(jmenu);

            for (Component jm : jmenu.getMenuComponents()) {

                ((JMenuItem) jm).addActionListener(e -> {
                    Component c = jpopup.getInvoker();
                    JButton menuDepart = (JButton) c;
                    //menuDepart.setText("  " + ((JMenuItem) jm).getText());
                    //menuDepart.setText(" " + ((JMenuItem) e.getSource()).getText());
                    menuDepart.setText("" + e.getActionCommand());

                    JButton menuArrivee = (JButton) ((JPanel) c.getParent().getParent().getComponent(2)).getComponent(0);

                    if (((JMenuItem) jm).isArmed()) {

                        xDepart = jmenu.getX();
                        yDepart = jmenu.getY();

                        xArrivee = 0;
                        yArrivee = 0;

                        actifJpopup = ajouterJpop(jmenu.getActionCommand());

                        String labelBouton2 = ((JMenuItem) jmenu.getMenuComponent(0)).getText();
                        menuArrivee.setText(labelBouton2);

                    }

                });
            }

        }
        );

    }

    private JPopupMenu ajouterJpop(String str) {

        JPopupMenu jp = new JPopupMenu();

        jmenuItemMap.get(str).forEach(jmenu -> {
            jp.add(jmenu);
            jp.setPopupSize(190, jp.getComponentCount() * 30);
            jp.setBackground(new Color(250, 250, 250));
            jp.setFocusable(false);
            jp.setBorderPainted(false);

            jmenu.setBorderPainted(false);

            if (jmenu.getActionListeners().length == 0) {
                jmenu.addActionListener(e -> {
                    Component c = jp.getInvoker();
                    JButton menuArrivee = (JButton) c;

                    if (((JMenuItem) e.getSource()).getText() != null) {
                        System.out.println("\t" + ((JMenuItem) e.getSource()).getText());
                    }
                    menuArrivee.setText("" + ((JMenuItem) e.getSource()).getText());
                    xArrivee = jmenu.getX();
                    yArrivee = jmenu.getY();

                });
            }
        });

        return jp;
    }

    /**
     * ************************
     *
     * @param jp
     * @param str
     */
//    private void ajouterJpop(JPopupMenu jp, String str) {
//
//        jmenuItemMap.get(str).forEach(jmenu -> {
//            jp.add(jmenu);
//            jp.setPopupSize(190, jp.getComponentCount() * 40);
//            jp.setBackground(new Color(250, 250, 250));
//            jp.setFocusable(false);
//            jp.setBorderPainted(false);
//            jmenu.addActionListener(e -> {
//                Component c = jp.getInvoker();
//                JButton menuDepart = (JButton) c;
//                //menuDepart.setText("  " + ((JMenuItem) jm).getText());
//                menuDepart.setText(" " + jmenu.getText());
//                xArrivee = jmenu.getX();
//                yArrivee = jmenu.getY();
//
//            });
//        });
//    }
}
