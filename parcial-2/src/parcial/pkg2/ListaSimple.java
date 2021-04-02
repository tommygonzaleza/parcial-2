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

    public void Encolar(Object data) {
        NodePila newNode = new NodePila(data);
        if (!Es_vacia()) {
            first = newNode;
            last = newNode;
        } else {
            NodePila aux = last;
            aux.setpNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void Desencolar() {
        if (!Es_vacia()) {
            first = first.getpNext();
            if (first == null) {
                last = null;
            }
        }
        size--;

    }

    public int Nivel(String a) {
        if (a.equals("+") ) {
            return 0;
        } else if (a.equals("*")|| (a.equals("/"))) {
            return 1;
        } else if (a.equals("^")) {
            return 2;
        } else {
            return -1;
        }
    }

    public ListaSimple cambiar() {
        Pila pila = new Pila();
        ListaSimple cola = new ListaSimple();
        NodePila aux = first;
        while (!this.Es_vacia() && aux != null) {
            //System.out.println("hola");
            if (isNumeric((String.valueOf(aux.getData())))) {
                cola.Insertar_final(String.valueOf(aux.getData()));
            } else if (isLetter((String.valueOf(aux.getData())))) {
                cola.Insertar_final(String.valueOf(aux.getData()));
            } else if (String.valueOf(aux.getData()).equals("(")) {
                pila.Push(String.valueOf(aux.getData()));
            } else if (String.valueOf(aux.getData()).equals(")")) {
                while (!pila.Es_vacia() && !String.valueOf(pila.getpTop().getData()).equals("(")) {
                    cola.Insertar_final(String.valueOf(pila.getpTop().getData()));
                    pila.Pop();
                }
                if (String.valueOf(pila.getpTop().getData()).equals("(")) {
                    //cola.Insertar_final(String.valueOf(aux.getData()));
                    pila.Pop();
                } else {
                    System.out.println("Se ha detectado un error");
                }

            }  else if (String.valueOf(aux.getData()).equals("*")||String.valueOf(aux.getData()).equals("+")||String.valueOf(aux.getData()).equals("-") 
                    || String.valueOf(aux.getData()).equals("/") ||String.valueOf(aux.getData()).equals("^")){
                //System.out.println("hola");
                     
                //System.out.println("hola");

                while (!pila.Es_vacia() && (Nivel(String.valueOf(pila.getpTop().getData())) >= Nivel(String.valueOf(aux.getData())))) {
                    
                    
                    cola.Insertar_final(String.valueOf(pila.getpTop().getData()));
                    pila.Pop();
                    
                }
                pila.Push(String.valueOf(aux.getData()));
                
            }
            //cola.Imprimir_lista();
            System.out.println(aux.getData());
            aux = aux.getpNext();
            

        }
        while (!pila.Es_vacia()) {
            cola.Insertar_final(String.valueOf(pila.getpTop().getData()));
            pila.Pop();
        }
        //pila.Empty();
        return cola;
    }

    public boolean isNumeric(Object a) {
        String b = String.valueOf(a);
        for (int i = 0; i < b.length(); i++) {
            if (!Character.isDigit(b.charAt(i))) {
                return false;
            }

        }
        return true;
    }

    public boolean isLetter(Object a) {
        String b = String.valueOf(a);
        for (int i = 0; i < b.length(); i++) {
            if (!Character.isLetter(b.charAt(i))) {
                return false;
            }

        }
        return true;
    }

}
