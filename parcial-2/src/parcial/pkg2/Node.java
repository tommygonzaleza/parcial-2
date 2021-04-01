/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.pkg2;

/**
 *
 * @author Tomas
 */
public class Node {
    private Node left;
    private Node right;
    private int data;
    private Node padre;
    
    
    public Node(int data){
        
        this.left=null;
        this.right=null;
        this.data=data;
        
        
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @return the red
     */
    

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the fe
     */
    

    /**
     * @param fe the fe to set
     */
   

    /**
     * @return the padre
     */
    public Node getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Node padre) {
        this.padre = padre;
    }

    
    
    /**
     * Esta funcion devuelve si es hoja o no
     *
     * @return true o false dependiendo si es hoja o no
     */
    
    public boolean esHoja(){
        if(this.getLeft() != null || this.getRight() != null){
            return false;
        } else{
            return true;
        }
    }
    
    /**
     * Esta funcion muestra los nodos completos
     *
     * @param n elemento del nodo
     * @return los nodos completos
     */
    
    public int nodosCompletos(Node n){
        if(n == null){
            return 0;
        }else{
            if(n.getLeft()!=null && n.getRight()!=null){
                return nodosCompletos(n.getLeft())+nodosCompletos(n.getRight())+1;
            }
            return nodosCompletos(n.getLeft())+nodosCompletos(n.getRight());
        }
    }
}
