/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

import controlador.listas.exception.PositionException;
import controlador.listas.exception.VacioException;
import java.lang.reflect.Field;

/**
 *
 * @author santiago
 */
public class LinkedList<E> {

    private Nodo<E> head;
    private Nodo<E> last;
    private Integer size;
    private Field field;
    private String typeField;

    public LinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean isEmpty() {
        return head == null || size == 0;
    }

    protected void addFirst(E data) {
        if (isEmpty()) {
            Nodo<E> aux = new Nodo<>(data, null);
            head = aux;
            last = aux;
        } else {
            Nodo<E> headOld = head;
            Nodo<E> aux = new Nodo<>(data, headOld);
            head = aux;
        }
        size++;
    }

    protected void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Nodo<E> aux = new Nodo<>(data, null);
            last.setNext(aux);
            last = aux;
            size++;
        }

    }

    public void add(E data) {
        addLast(data);
    }

    public void add(E data, Integer pos) throws VacioException {
        if (pos == 0) {
            addFirst(data);
        } else if (pos.intValue() == size.intValue()) {
            addLast(data);
        } else {
            Nodo<E> search_preview = getNode(pos - 1);
            Nodo<E> search = getNode(pos);
            Nodo<E> aux = new Nodo<>(data, search);
            search_preview.setNext(aux);
            size++;

        }
    }

    public E getFirst() throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            return head.getData();
        }
    }

    public E getLast() throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {
            return last.getData();
        }
    }

    public E get(Integer index) throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else if (index.intValue() < 0 || index.intValue() >= size) {
            throw new IndexOutOfBoundsException("Fuera de Rango");
        } else if (index.intValue() == 0) {
            return getFirst();
        } else if (index.intValue() == (size - 1)) {
            return getLast();
        } else {
            Nodo<E> search = getNode(index);
            return search.getData();
        }
    }

    public Nodo<E> getNode(Integer pos) throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Esta Vacia ");
        } else if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Error esta fuera de los limites de la lista");
        } else if (pos == 0) {
            return head;
        } else if (pos == (size - 1)) {
            return last;
        } else {
            Nodo<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("Lista Vacia");
        } else {
            Nodo<E> aux = head;
            while (aux != null) {
                sb.append(aux.getData().toString()).append("\n");
                aux = aux.getNext();
            }
        }
        return sb.toString();
    }

    public void update(E dato, Integer pos) throws VacioException, PositionException {
        if (isEmpty()) {
            throw new VacioException("Lista Vacia");
        } else {

            if (pos >= 0 && pos < getSize()) {
                if (pos == 0) {
                    head.setData(dato);
                } else {
                    Nodo<E> aux = head;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getNext();
                    }
                    aux.setData(dato);
                }

            } else {
                throw new PositionException("Posición fuera de rango");
            }
        }
    }

    public void Update2(E data, Integer pos) throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Esta Vacia ");
        } else if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Error esta fuera de los limites de la lista");
        } else if (pos == 0) {
            head.setData(data);
        } else if (pos == (size - 1)) {
            last.setData(data);
        } else {
            Nodo<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                cont++;
                search = search.getNext();
            }
            search.setData(data);
        }
    }

    public void clear() {
        head = null;
        size = 0;
        last = null;
    }

    //Hacer Eliminar
    public E deleteFirst() throws VacioException {
        if (isEmpty()) {
            throw new VacioException("List Empty");
        } else {

            E element = head.getData();
            Nodo<E> aux = head.getNext();
            head = aux;
            if (size.intValue() == 1) {
                last = null;
            }
            size--;
            return element;
        }
    }

    public E deleteLast() throws VacioException {
        if (isEmpty()) {
            throw new VacioException("List Empty");
        } else {

            E element = last.getData();
            Nodo<E> aux = getNode(size - 2);
            if (aux == null) {
                last = null;
                if (size == 2) {
                    last = head;
                } else {
                    head = null;
                }
            } else {
                last = null;
                last = aux;
                last.setNext(null);
            }

            size--;
            return element;
        }
    }

    public E delete(Integer pos) throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Lista Esta Vacia ");
        } else if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Error esta fuera de los limites de la lista");
        } else if (pos == 0) {
            return deleteFirst();
        } else if (pos == (size - 1)) {
            return deleteLast();
        } else {
            Nodo<E> preview = getNode(pos - 1);
            Nodo<E> actually = getNode(pos);
            E element = preview.getData();

            Nodo<E> next = actually.getNext();
            actually = null;
            preview.setNext(next);
            size--;
            return element;
        }

    }

    public E[] toArray() {
        Class clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            clazz = head.getData().getClass();
            matriz = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            Nodo<E> aux = head;
            for (int i = 0; i < size; i++) {
                matriz[i] = aux.getData();
                aux = aux.getNext();
            }
        }
        return matriz;
    }

    public LinkedList<E> toList(E[] m) {
        clear();
        for (int i = 0; i < m.length; i++) {
            this.add(m[i]);
        }

        return this;
    }
}
