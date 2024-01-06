/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.interfazDAO;

import com.thoughtworks.xstream.XStream;
import controlador.listas.LinkedList;
import controlador.listas.exception.VacioException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santiago
 */
public class DataAccessObject<T> implements TransferObject<T> {

    private XStream xstream;
    private Class<T> clazz;
    private String URL;

    public DataAccessObject(Class<T> clazz) {
        xstream = Connection.getXstream();
        this.clazz = clazz;

        URL = Connection.getURL() + this.clazz.getSimpleName() + ".json";

    }

    @Override
    public Boolean save(T data) {
        LinkedList<T> list = listAll();
        list.add(data);
        try {
//            xstream.alias(list.getClass().getName(), LinkedList.class);
            xstream.toXML(list, new FileOutputStream(URL)); //This porsiaca
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(T data, Integer index) {
        LinkedList<T> list = listAll();
        try {
            list.Update2(data, index);
            xstream.toXML(list, new FileOutputStream(URL));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public T find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer generated_id() {
        return listAll().getSize() + 1;
    }

    public String getURL() {
        return URL;
    }

    public XStream getXStream() {
        return xstream;
    }

    @Override
    public LinkedList<T> listAll() {

        LinkedList<T> lista = new LinkedList<>();

        try {

            lista = (LinkedList<T>) xstream.fromXML(new FileReader(URL));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public Boolean delete(Integer index) {
        
        LinkedList<T> list = listAll();

        try {
            list.delete(index);
        } catch (VacioException ex) {
            return false;
        }
        
        try {
//            xstream.alias(list.getClass().getName(), LinkedList.class);
            xstream.toXML(list, new FileOutputStream(URL)); //This porsiaca
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

}
