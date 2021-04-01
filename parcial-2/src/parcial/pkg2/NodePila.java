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
public class NodePila {
    private Object data;
    private NodePila pNext;
    
    public NodePila(Object data){
        this.pNext=null;
        this.data=data;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public NodePila getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodePila pNext) {
        this.pNext = pNext;
    }
    
}
