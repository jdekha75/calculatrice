/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

import ma.dekha.calculatrice.Principale;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author linux
 */
public class ConteneurPrincipal extends JPanel {

    public ConteneurPrincipal(JTextComponent jt) {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(710, 400));
        setMinimumSize(new Dimension(710, 400));

        add(new HistoriqueConteneur());
        add(new ConteneurSud(jt), BorderLayout.SOUTH);

        try {
            /*        
           for (Handler h : Logger.getLogger(Principale.class.getName()).getHandlers()){
           System.out.println("Handler " + h.getClass().getName());
       }*/
             
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            
            
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");            
           //UIManager.setLookAndFeel ("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
           //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
         

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);

        }

        SwingUtilities.updateComponentTreeUI(this);

    }

}
