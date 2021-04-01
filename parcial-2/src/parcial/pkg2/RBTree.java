/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.pkg2;


import javax.swing.JOptionPane;

/**
 *
 * @author Tomas
 */

public class RBTree {

    private Node root;

    public RBTree() {

        this.root = null;
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Esta funcion busca un nodo en el arbol y lo devuelve
     *
     * @param d elemento del nodo
     * @param root raiz del arbol y subarboles
     * @return el nodo del elemento d
     */
    
    public Node search(int d, Node root) {
        if (this.root == null) {
            return null;
        } else if (root.getData() == d) {
            return root;
        } else if (root.getData() < d) {
            return search(d, root.getRight());
        } else {
            return search(d, root.getLeft());
        }
    }
    /**
     * Metodo para verificar si un elemento existe
     * @param i elemento del nodo
     * @param root raiz del arbol
     * @return si esta o no esta el elemento
     */
    public boolean Search( int i, Node root){
        boolean aux=false;
        if (root==null) {
            return false;
        }else{
            if (i==root.getData()) {
                return aux=true;
            }else if (root!=null){
                 if (i<root.getData()) {
                    aux=Search(i,root.getLeft());
                }else{
                     aux=Search(i,root.getRight());
                 }
            
            }
            
        }
        return aux;    
        
    }


 

    /**
     * Este metodo devueleve el padre de un nodo, si no tiene los hijos
     * completos
     *
     * @param root raiz del arbol
     * @param data dato del nodo que se quiere buscar
     * @return Padre del nodo
     */
    public Node SearchFather(Node root, int data) {
        Node encontrado = null;
        if (data < root.getData()) {
            if (encontrado != null) {
                return encontrado;

            } else if (root.getLeft() != null) {
                encontrado = SearchFather(root.getLeft(), data);

            } else {
                return root;
            }
        } else if (data > root.getData()) {
            if (encontrado != null) {
                return encontrado;

            } else if (root.getRight() != null) {
                encontrado = SearchFather(root.getRight(), data);

            } else {
                return root;
            }
        }

        return encontrado;
    }

    /*
    public void printPreorder(Node root) {
        System.out.println(root.getData());
        if (root.getLeft() != null) {
            printPreorder(root.getLeft());
        }
        if (root.getRight() != null) {
            printPreorder(root.getRight());

        }
    }
    */
    

    
    
    

    
    
    
}
