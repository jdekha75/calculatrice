/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author linux
 */
public class ConteneurSud extends JPanel {

    public ConteneurSud(JTextComponent jt) {

        setLayout(new BorderLayout(0,0));
        //setPreferredSize(new Dimension(700, 280));

        JPanel panel = new JPanel(new BorderLayout(0, 0));

        panel.add(new ResultatAfficheur(jt), BorderLayout.NORTH);
       
        panel.add(new UniteDeMesuresAfficheur(), BorderLayout.SOUTH);

        add(panel, BorderLayout.NORTH);
        add(new CommandeConteneur());

    }

}
