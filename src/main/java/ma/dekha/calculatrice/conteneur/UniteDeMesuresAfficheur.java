/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import ma.dekha.calculatrice.ecouteur.MenuArriveeActionListener;
import ma.dekha.calculatrice.ecouteur.ToMouseListener;
import ma.dekha.calculatrice.ecouteur.MenuDepartActionListener;

/**
 *
 * @author linux
 */
public class UniteDeMesuresAfficheur extends JPanel {

    JPanel fromMesurePanel = new JPanel(new BorderLayout());
    //JPanel fromMesurePanel = new JPanel(new FlowLayout(HEIGHT, 0, 0));
    JPanel toMesurePanel = new JPanel(new FlowLayout(HEIGHT, 0, 0));

    JButton menuDepart = new JButton("  Megaoctet");
    JButton flecheFrom = new flecheBouton();

    JButton to = new JButton("to");

    JButton menuArrivee = new JButton("  tomesurebutton");
    JButton flecheTo = new flecheBouton();

    JPanel convertiseurPanel = new JPanel();

    JPopupMenu jpopupFrom = new JPopupMenu();
    JPopupMenu jpopupTo = new JPopupMenu();

    public UniteDeMesuresAfficheur() {

        this.setLayout(new BorderLayout(0, 0));
        //this.setPreferredSize(new Dimension(710, 55));
        this.setBackground(new Color(250, 250, 250));
        //new JPanel().

        fromMesurePanel.add(menuDepart, BorderLayout.WEST);
        fromMesurePanel.add(flecheFrom, BorderLayout.EAST);
        toMesurePanel.add(menuArrivee);
        toMesurePanel.add(flecheTo);

        // convertiseurPanel.setBackground(new Color(250, 250, 250));
        convertiseurPanel.add(fromMesurePanel);
        convertiseurPanel.add(to);
        convertiseurPanel.add(toMesurePanel);

        add(convertiseurPanel, BorderLayout.WEST);
        JLabel jl = new JLabel("jalabert    ");
        jl.setHorizontalAlignment(SwingConstants.RIGHT);

        add(jl, BorderLayout.EAST);

        /**
         * *************************************************
         * configuration bouton FromMesure
         * **************************************************
         */
        //fromMesure.setBorder(new FromMesureBorder());
        menuDepart.setBackground(Color.WHITE);
        menuDepart.setPreferredSize(new Dimension(170, 30));
        menuDepart.setFocusable(false);
        menuDepart.setHorizontalAlignment(SwingConstants.LEFT);
        menuDepart.addActionListener(new MenuDepartActionListener());
        menuDepart.setMargin(new Insets(0, 0, 0, 0));

        /**
         * ************************************************
         */
        /**
         * *************************************************
         * configuration bouton FromMesure
         * **************************************************
         */
        to.setBackground(new Color(to.getParent().getBackground().getRGB()));
        to.addMouseListener(new ToMouseListener());
        to.setPreferredSize(new Dimension(50, 30));
        //to.setBorder(new FromMesureBorder());
        to.setFocusable(false);
        to.setBorderPainted(false);
        to.setMargin(new Insets(0, 0, 0, 0));
        /**
         * *************************************************
         */

        /**
         * *************************************************
         * configuration bouton FromMesure
         * **************************************************
         */
        //toMesure.setBorder(new FromMesureBorder());
        menuArrivee.setBackground(Color.WHITE);
        menuArrivee.setPreferredSize(new Dimension(150, 30));
        menuArrivee.setFocusable(false);
        menuArrivee.setHorizontalAlignment(SwingConstants.LEFT);
        menuArrivee.addActionListener(new MenuArriveeActionListener());
        menuArrivee.setMargin(new Insets(0, 0, 0, 0));
        /**
         * ************************************************ /**
         * ************************************************
         */

        //MesureListe mesureListe = new MesureListe();
        to.setComponentPopupMenu(jpopupTo);
        jpopupFrom.setFocusable(false);

        jpopupFrom.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

                // JPopupMenu jpopup = ((JPopupMenu) (e.getSource()));
                // jpopup.getComponent().setBackground(Color.red);
                // jpopup.validate();
                //jpopup.getSelectionModel().
                // (JButton)(jpopup).set
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JMenuBar angle = new JMenuBar() {
            @Override
            public String toString() {
                return "Angle";
            }

        };
        /* JMenu longueur = new JMenu("Longueur"){
            @Override
            public String toString() {
                return "Angle";
            }
            
        }; 
        JMenu surface = new JMenu("Surface");
        JMenu volume = new JMenu("Volume");
        JMenu poid = new JMenu("Poid");
        JMenu duree = new JMenu("Durée");
        JMenu temperature = new JMenu("Temperature");
        JMenu stockage = new JMenu("Stockage Digital");*/
        JMenuBar[] tableauJMenu = new JMenuBar[]{angle};//, longueur, surface, volume, poid, duree, temperature, stockage};

        JMenuItem degres = new JMenuItem("Degres");
        JMenuItem radians = new JMenuItem("Radians");
        JMenuItem gradians = new JMenuItem("Gradians");
        angle.add(degres);
        angle.add(radians);

        JComboBox<JMenuBar> combo = new JComboBox<>(tableauJMenu);
        // add(combo);
    }

    class flecheBouton extends JButton {

        public flecheBouton() {
            //super("\u2304");
            super("\u25BE");

            getFont().deriveFont(22F);
            setBorderPainted(false);
            setFocusable(false);

            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("flecheFrom")) {
                        new MenuDepartActionListener().actionPerformed(e);
                    }
                }
            });

        }

    }

}
