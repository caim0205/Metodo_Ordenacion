/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Censador;

/**
 *
 * @author santiago
 */
public class ModeloTablaCensador extends AbstractTableModel {

    private LinkedList<Censador> censadores = new LinkedList<>();

    public LinkedList<Censador> getCensadores() {
        return censadores;
    }

    public void setCensadores(LinkedList<Censador> censadores) {
        this.censadores = censadores;
    }

    @Override
    public int getRowCount() {
        return censadores.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Censador censador = null;

        try {
            censador = censadores.get(row);
        } catch (Exception e) {
        }

        switch (col) {
            case 0:
                return (censador != null) ? censador.getNombre() : " ";
            case 1:
                return (censador != null) ? censador.getApellido(): " ";
            case 2:
                return (censador != null) ? censador.getDni() : " ";
            case 3:
                return (censador != null) ? censador.getCorreo(): " ";

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "DNI";
            case 3:
                return "Correo electronico";
            default:
                return null;
        }
    }

}
