/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.util;

import controlador.CensadorController;
import controlador.listas.exception.VacioException;
import javax.swing.JComboBox;
import modelo.Censador;

/**
 *
 * @author santiago
 */
public class UtilVista {

    public static void cargarCensadores(JComboBox cbxCensador) throws VacioException {
        CensadorController mc = new CensadorController();
        cbxCensador.removeAllItems();

        for (int i = 0; i < mc.getCensadores().getSize(); i++) {
           cbxCensador.addItem(mc.getCensadores().get(i));
        }
    }
   
    public static Censador getComboCensador(JComboBox cbx) {
        return (Censador) cbx.getSelectedItem();
    }

}
