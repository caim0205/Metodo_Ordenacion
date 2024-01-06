/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

/**
 *
 * @author santiago
 */
public class Nodo<E> {

    private E data;
    private Nodo<E> next;

    public Nodo() {
        next = null;
    }

    public Nodo(E data) {
        this.data = data;
        next = null;
    }

    public Nodo(E data, Nodo<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }

}
