/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import ma.dekha.calculatrice.Fenetre;
import ma.dekha.calculatrice.ecouteur.ClavierActionListener;

/**
 *
 * @author linux
 */
public class ResultatAfficheur extends JPanel {

    private static JTextComponent jtextResultat;
    private static JLabel jtextException;

    private static UndoManager undoManager;
    private static DefaultStyledDocument abstDoc;

    public ResultatAfficheur(JTextComponent jtextResultat) {
        {
            this.jtextResultat = jtextResultat;
            this.jtextException = new JLabel("");

//        this.jtextException.setBackground(new Color(255, 255, 255));
            this.setBackground(new Color(255, 255, 255));

            this.jtextException.setPreferredSize(new Dimension(700, 30));

            this.setLayout(new BorderLayout(0, 0));

            this.jtextResultat.setPreferredSize(new Dimension(700, 45));
            this.jtextResultat.setFont(this.jtextResultat.getFont().deriveFont(20F));

            this.jtextResultat.setBorder(new Border() {

                @Override
                public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

                    g.setColor(new Color(190, 190, 190));
                    g.drawLine(x - 1, y, width + 1, y);
                    //g.drawLine(x - 1, y + height - 1, width + 1, y + height - 1);
                }

                @Override
                public Insets getBorderInsets(Component c) {

                    return new Insets(10, 10, 0, 0);
                }

                @Override
                public boolean isBorderOpaque() {
                    return true;
                }
            });

            this.jtextException.setBorder(new Border() {

                @Override
                public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

                    g.setColor(new Color(190, 190, 190));
                    //g.drawLine(x - 1, y, width + 1, y);
                    g.drawLine(x - 1, y + height - 1, width + 1, y + height - 1);

                }

                @Override
                public Insets getBorderInsets(Component c) {
                    return new Insets(10, 10, 10, 0);
                }

                @Override
                public boolean isBorderOpaque() {
                    return false;
                }
            });

            this.undoManager = new UndoManager();
            abstDoc = (DefaultStyledDocument) ((JTextPane) (jtextResultat)).getStyledDocument();
            abstDoc.addUndoableEditListener(undoManager);

            //Keymap keyMap = jt.getKeymap();  <---- ne marche pas
            Keymap keyMap = JTextComponent.getKeymap(JTextComponent.DEFAULT_KEYMAP); //== 

            String touche = "0123456789,.()−-+×x*/÷=";
            touche += System.lineSeparator();
            //touche += KeyEvent.VK_ENTER;
            int taille = touche.length();

            for (int i = 0; i < taille; i++) {
                KeyStroke key = KeyStroke.getKeyStroke(touche.charAt(i));
                keyMap.addActionForKeyStroke(key, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ClavierActionListener().actionPerformed(e);
                    }
                });
            }

            /*
   
         Action ctrlAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not allowed");
            }
        };
        KeyStroke ctrlV = KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK);
        keyMap.addActionForKeyStroke(ctrlV, ctrlAction);
 
             */
            // KeyStroke entree = KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER);
            //keyMap.addActionForKeyStroke(entree, action);
            //ne marche pas
            //keyMap.addActionForKeyStroke(entree, keyMap.getAction(KeyStroke.getKeyStroke((char) KeyEvent.VK_EQUALS)));
            jtextResultat.addCaretListener(new CaretListener() {
                @Override
                public void caretUpdate(CaretEvent e) {
                    Fenetre.light(e.getDot());
                }
            });
        }
        add(this.jtextResultat, BorderLayout.NORTH);
        add(this.jtextException, BorderLayout.SOUTH);
    }

    public static void undo() {
        try {
            ResultatAfficheur.undoManager.undo();
        } catch (CannotUndoException can) {

        }
    }
    /*
    *
       DocumentFilter.FilterBypass byPass = new DocumentFilter.FilterBypass() {
            @Override
            public Document getDocument() {
                return jtextResultat.getDocument();
            }

            @Override
            public void remove(int offset, int length) throws BadLocationException {
            }

            @Override
            public void insertString(int offset, String string, AttributeSet attr) throws BadLocationException {
                traiter();
                ControleurAffiche.traite(string);
                //string = "";

            }

            @Override
            public void replace(int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            }
        };

        DefaultStyledDocument defStylDoc = (DefaultStyledDocument) ((JTextPane) (jtextResultat)).getStyledDocument();

        jtextResultat.setDocument(new DefaultStyledDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {

                if (!traite) {
                    byPass.insertString(offs, str, attr);
                }
                else {
                    traiter();
                    super.insertString(offs, str, attr);
                }
            }

        });
     */
}
