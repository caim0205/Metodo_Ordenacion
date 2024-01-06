/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Censo;

/**
 *
 * @author santiago
 */
public class ModeloTablaCenso extends AbstractTableModel {

    private LinkedList<Censo> censos = new LinkedList<>();

    public LinkedList<Censo> getCensos() {
        return censos;
    }

    public void setCensos(LinkedList<Censo> censos) {
        this.censos = censos;
    }

    @Override
    public int getRowCount() {
        if (censos != null) {
            return censos.getSize();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Censo censo = null;

        try {
            censo = censos.get(row);
        } catch (Exception e) {
        }

        switch (col) {
            case 0:
                return (censo != null) ? censo.getNombrePersona() : " ";
            case 1:
                return (censo != null) ? censo.getEstadoCivil() : " ";
            case 2:
                return (censo != null) ? censo.getFecha() : " ";
            case 3:
                return (censo != null) ? censo.getMotivo() : " ";
            case 4:
                return (censo != null) ? censo.getDuracionRelacion() : " ";
            case 5:
                return (censo != null) ? censo.getEstadoEmocional() : " ";
            case 6:
                return (censo != null) ? censo.getCensador() : " ";

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
                return "Estado civil";
            case 2:
                return "Fecha";
            case 3:
                return "Motivo";
            case 4:
                return "Duracion(Años)";
            case 5:
                return "Estado emocional";
            case 6:
                return "Censador";
            default:
                return null;
        }
    }

}
