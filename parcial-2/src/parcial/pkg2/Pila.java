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
public class Pila {
    private NodePila pTop;
    private NodePila pLast;
    private int size;
    public Pila(){
        this.pTop=null;
        this.pLast=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return getpTop()==null;
    }

    /**
     * @return the pTop
     */
    public NodePila getpTop() {
        return pTop;
    }

    /**
     * @param pTop the pTop to set
     */
    public void setpTop(NodePila pTop) {
        this.pTop = pTop;
    }

    /**
     * @return the pLast
     */
    public NodePila getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodePila pLast) {
        this.pLast = pLast;
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
    
    
    public void Empty(){
        this.pTop=this.pLast=null;
        this.size=0;
    }
    public void Push(Object data){
        NodePila node =new NodePila((String) data);
        if (isEmpty()) {
            this.pTop=this.pLast=node;
        }else{
            node.setpNext(this.pTop);
            this.pTop=node;
        }
        size ++;
    }
    public void Pop(){
        if (!isEmpty()) {
            if(size==1){
                this.Empty();
            }else{
                this.pTop=this.pTop.getpNext();
                size --;
            }
            
        }
    }
    public void PrintPilaRecursiva(){
        String data="";
        data=AuxiliarPrint(data);
        System.out.println(data);
    }
    public String AuxiliarPrint(String data){
        if (!this.isEmpty()) {
            Object nodeData=this.pTop.getData();
            data+=nodeData + ",";
            this.Pop();
            data= AuxiliarPrint(data);
            this.Push(nodeData);
        }
        return data;
    }
    public void PrintPilaRecursivaReverse(){
        String data="";
        data=AuxiliarPrintReverse(data);
        System.out.println(data);
    }
    public String AuxiliarPrintReverse(String data){
        if (!this.isEmpty()) {
            Object nodeData=this.pTop.getData();
            
            this.Pop();
            data= AuxiliarPrintReverse(data);
            data+=nodeData + ",";
            this.Push(nodeData);
        }
        return data;
    }
    public boolean Es_vacia() {
        return pTop == null;
    }
    
    
    
}
