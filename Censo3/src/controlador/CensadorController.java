/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.interfazDAO.DataAccessObject;
import controlador.listas.LinkedList;
import java.io.IOException;
import modelo.Censador;

/**
 *
 * @author santiago
 */
public class CensadorController extends DataAccessObject<Censador> {

    private LinkedList<Censador> censadores = new LinkedList<>();
    private Censador censador;

    public CensadorController() {
        super(Censador.class);
    }

    public LinkedList<Censador> getCensadores() {
        if (censadores.isEmpty()) {
            censadores = this.listAll();
        }
        return censadores;
    }

    public void setCensadores(LinkedList<Censador> censadores) {
        this.censadores = censadores;
    }

    public Censador getCensador() {
        if (censador == null) {
            censador = new Censador();

        }
        return censador;
    }
    
    
    

    public void setCensador(Censador censador) {
        this.censador = censador;
    }

    public Boolean save() {
        this.censador.setId(generated_id());
        return this.save(censador);
    }

    public void update(Integer pos) throws IOException {
        this.update(censador, pos);
    }

    public String generatedCode() {
        StringBuilder code = new StringBuilder();
        Integer length = listAll().getSize()+ 1;
        Integer pos = length.toString().length();
        for (int i = 0; i < (10 - pos); i++) {
            code.append("0");
        }
        code.append(length.toString());
        return code.toString();
    }
    
   
}
