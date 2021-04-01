/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.pkg2;

/**
 *
 * @author Jrios
 */
public class ListaSimple {

    private NodePila first;
    private NodePila last;
    private int size;

    public ListaSimple() {
        this.first = null;
        this.last = null;
        this.size = 0;

    }

    /**
     * @return the first
     */
    public NodePila getFirst() {
        return first;
    }

    /**
     * @param first the fist to set
     */
    public void setFirst(NodePila first) {
        this.first = first;
    }

    /**
     * @return the fin
     */
    public NodePila getLast() {
        return last;
    }

    /**
     * @param last the fin to set
     */
    public void setLast(NodePila last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public String Imprimir_lista() {
        String lista_completa = "";
        NodePila actual = first;
        while (actual != null) {
            lista_completa += actual.getData() + ",";
            actual = actual.getpNext();

        }
        System.out.println(lista_completa);
        return lista_completa;

    }

    public boolean Es_vacia() {
        return first == null;
    }

    public void Vaciar_lista() {
        first = last = null;
        size = 0;
    }

    public void Insertar_final(Object data) {
        NodePila nuevo = new NodePila(data);
        if (Es_vacia()) {
            first = last = nuevo;
        } else {
            last.setpNext(nuevo);
            last = nuevo;
        }
        size++;
    }

    public void imprimir() {
        NodePila aux = first;
        for (int i = 0; i < size; i++) {
            System.out.println(aux.getData());
            //System.out.print(",");
            aux = aux.getpNext();

        }
    }

}
