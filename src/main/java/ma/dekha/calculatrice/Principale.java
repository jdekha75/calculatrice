/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author linux
 */
public class Principale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //for (Font f : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()){
        //  System.out.println(f.getFamily() + " " + f.getName());
        //GraphicsEnvironment.getLocalGraphicsEnvironment().
        //UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        EventQueue.invokeLater(() -> {

            System.out.println("dans main" + String.format("%,.5g", 2.718281828));
            Dimension dimensionDelEcran = Toolkit.getDefaultToolkit().getScreenSize();

            Fenetre fenetre;
            fenetre = new Fenetre();
            fenetre.setLocation((int) (dimensionDelEcran.getWidth() / 4), (int) (dimensionDelEcran.getHeight() / 4));

           // fenetre.setTitle("Calculatrice");
            fenetre.setMinimumSize(new Dimension(700, 450));
            fenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
            URL url = Principale.class.getClassLoader().getResource("cal-24.png");
            Image image = Toolkit.getDefaultToolkit().getImage(url);
           // ImageIcon imageIcon = new ImageIcon(url);
            //Image img = imageIcon.getImage();
            fenetre.setIconImage(image);
            fenetre.setLocationByPlatform(true);
            fenetre.setVisible(true);
            fenetre.pack();
        });
    }

}
