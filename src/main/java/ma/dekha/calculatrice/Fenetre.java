/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.undo.CannotUndoException;

import ma.dekha.calculatrice.conteneur.ConteneurPrincipal;
import ma.dekha.calculatrice.conteneur.ResultatAfficheur;
import ma.dekha.calculatrice.traitement.Parenthese;
import model.PopUp;

/**
 * @author linux
 */
public class Fenetre extends JFrame {

    /**
     * • If you write an application that takes advantage of multiple display
     * screens, use the GraphicsEnvironment and GraphicsDevice classes to find
     * the dimensions of the display screens. • The GraphicsDevice class also
     * lets you execute your application in full-screen mode.
     */
    private static JTextPane jt;

    private static PopUp menuPopUp;

    static private int p0 = 0;
    static private int p1 = 0;
    boolean traite;

    static private Highlighter.HighlightPainter blancHigh;
    static private Highlighter.HighlightPainter jauneHigh;
    private static Object objectLighterLeft = null;
    private static Object objectLighterRight = null;

    public Fenetre() {
        JButton click = new JButton("CLICK");
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.putClientProperty("Left", ""
                + "borderColor:$TitlePane.background;"
                + "border:0,0,0,0");
        jMenuBar.add(click);
       // this.setJMenuBar(jMenuBar);
        jt = new JTextPane();
        menuPopUp = new PopUp();
        // menuPopUp = ModelFactory.getMenuPopUp();
        SimpleAttributeSet attrRouge = new SimpleAttributeSet();
        attrRouge.addAttribute(StyleConstants.Background, new Color(255, 0, 46));
        SimpleAttributeSet attrJaune = new SimpleAttributeSet();
        attrJaune.addAttribute(StyleConstants.Background, new Color(255, 255, 0));
        blancHigh = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 255, 255));
        jauneHigh = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 255, 0));
        /**
         * for (Action action : ((DefaultEditorKit)
         * jt.getEditorKit()).getActions()) { if (action.getClass() ==
         * DefaultEditorKit.InsertContentAction.class) {
         * System.out.println("action " + action.getClass().getName()); action =
         * new DefaultEditorKit.InsertContentAction() {
         *
         * @Override public void actionPerformed(ActionEvent e) { JTextComponent
         * target = getTextComponent(e); if ((target != null) && (e != null)) {
         * if ((!target.isEditable()) || (!target.isEnabled())) {
         * UIManager.getLookAndFeel().provideErrorFeedback(target); return; }
         * String content = e.getActionCommand(); if (content != null) {
         * System.out.println("content " + content);
         * ControleurAffiche.traite(content); } else {
         * UIManager.getLookAndFeel().provideErrorFeedback(target); } } } };
         *
         * }
         * }
         */
        /**
         * DocumentFilter docFilter = new DocumentFilter() {
         *
         * @Override public void insertString(DocumentFilter.FilterBypass fb,
         * int offset, String string, AttributeSet attr) throws
         * BadLocationException { System.out.println("passage"); if (!traite) {
         * byPass.insertString(offset, string, attr); } else { traiter();
         * super.insertString(fb, offset, string, attr); }
         *
         * }
         * };
         */
        this.add(new ConteneurPrincipal(jt));
    }

    public static String getText() {
        return jt.getText();
    }

    public static void affiche(String str) {
        int position = jt.getCaretPosition();
        try {
            try {
                String s = jt.getSelectedText();
                if (s != null) {
                    int start = jt.getSelectionStart();
                    int end = jt.getSelectionEnd();
                    jt.getDocument().remove(start, end - start);
                    position = start;
                }
                DefaultStyledDocument abstDoc = (DefaultStyledDocument) jt.getStyledDocument();
                jt.getEditorKit().read(new StringReader(str), abstDoc, position);
                //light(jt.getCaretPosition());
            } catch (BadLocationException ex) {
                System.out.println("BadLocationException : Fenetre afficheMethode " + position);
            }
        } catch (IOException ex) {
            System.out.println("IOException : Fenetre afficheMethode");
        }
    }

    public static void clear() {
        jt.setText("");
    }

    public static void light(int position) {
        try {
            if (!jt.getText().isEmpty() && position <= jt.getText().length()) {
                if (objectLighterLeft != null) {
                    jt.getHighlighter().removeHighlight(objectLighterLeft);
                }
                if (objectLighterRight != null) {
                    jt.getHighlighter().removeHighlight(objectLighterRight);
                }
                if (position <= jt.getText().length() && position > 0 && jt.getText().charAt(position - 1) == '(') {
                    p0 = position - 1;
                    p1 = p0 + 1;
                    objectLighterLeft = jt.getHighlighter().addHighlight(p0, p1, jauneHigh);
                    p0 = Parenthese.positionFermante(jt.getText(), p0);
                    p1 = p0 + 1;
                    objectLighterRight = jt.getHighlighter().addHighlight(p0, p1, jauneHigh);
                }
                else if (position < jt.getText().length() && jt.getText().charAt(position) == '(') {
                    p0 = position;
                    p1 = p0 + 1;
                    objectLighterLeft = jt.getHighlighter().addHighlight(p0, p1, jauneHigh);
                    p0 = Parenthese.positionFermante(jt.getText(), p0);
                    p1 = p0 + 1;
                    objectLighterRight = jt.getHighlighter().addHighlight(p0, p1, jauneHigh);
                }
            }
            //throw new UnsupportedOperationExcetion("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (BadLocationException ex) {
            //Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void undo() {
        try {
            ResultatAfficheur.undo();
        } catch (CannotUndoException can) {
        }
    }

    public static void afficheMenuDepartPopUp(ActionEvent e) {
        Component c = (Component) e.getSource();
        menuPopUp.showDepart(e);
//        new PopUp().showDepart(c, 3, 3);
    }

    public static void afficheMenuArriveePopUp(ActionEvent e) {
        menuPopUp.showArrivee(e);
    }
}
