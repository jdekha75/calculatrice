/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ma.dekha.calculatrice.Fenetre;

/**
 *
 * @author linux
 */
public class MenuDepartActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //MesureListeJPopup.getJPopupFrom() ;

        //jpopupFrom.show((Component) (e.getSource()), x, y);
        //MesureListeJPopup.showup((Component) (e.getSource()));
        //((PopUp) PopUp.get()).show(e);
        Fenetre.afficheMenuDepartPopUp(e);

    }
}
