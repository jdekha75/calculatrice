/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dekha.calculatrice.conteneur;

/**
 *
 * @author linux
 */
class Mesure {

    private String label;

    public Mesure(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label; //To change body of generated methods, choose Tools | Templates.
    }

}
