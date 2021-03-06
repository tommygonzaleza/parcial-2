/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.pkg2;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Tomas
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    
    RBTree persona = new RBTree();//Crea arbol vacio
    Canvas canvas = new Canvas();
    Controller controller = new Controller(canvas, persona);
    boolean aux =false;
    
    /**
     * Esta funcion muestra el arbol
     *
     * @param arbol el arbol
     * @return arbol mostrado
     */
    
    public String mostrarArbol(RBTree arbol) {
        setLayout(null);
        JScrollPane scrollPane;       
        Canvas canvas = new Canvas();
        Controller controller = new Controller(canvas, arbol);
        controller.iniciar();
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 5, 20000, 6000);
        
        JFrame ventana = new JFrame();        

        canvas.setPreferredSize(new Dimension(11000, 2000));//Se agranda la dimension de la ventana
        
        scrollPane.setViewportView(canvas);
        ventana.getContentPane().add(scrollPane);
        ventana.setDefaultCloseOperation(1);
        ventana.setSize(1000, 900);
        ventana.setVisible(true);
        return "Arbol mostrado.";
    }
    public ListaSimple leer_txt(String filepath) {
        ListaSimple data = new ListaSimple();
        String[] expresion;
        String line;
        String clientes_txt = "";
        String path = filepath;
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        clientes_txt += line + "\n";
                    }

                }
                if (!"".equals(clientes_txt)) {
                    String[] clientes_split = clientes_txt.split("\n");
                    //System.out.println(clientes_split[0]);
                    
                    
                    //System.out.println(clientes_split[0]);
                    for (int i = 0; i < clientes_split[0].length(); i++) {
                        String letter = Character.toString(clientes_split[0].charAt(i));
                        if(!letter.equals(" ")){
                            data.Insertar_final(letter);
                        }
                        //String[] cliente = clientes_split[i].split(",");
                        //System.out.println(cliente[1]);
                        //System.out.println(cliente[0]);
                        //clientes.Insertar_final(cliente[0], Integer.parseInt(cliente[1]));
                    }
                }
                br.close();
                
                JOptionPane.showMessageDialog(null, "Exitos al Leer");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al leer");

        }

        return data;
    }
    
    public Interfaz() {
        initComponents();
    }
    ListaSimple lista= new ListaSimple();
    Pila pila = new Pila();
    
    public void TraduccionPostfijaArbol(RBTree persona, ListaSimple lista, Pila pila){
        		
            /*
            Pongan comentarios aqu??, si quieren preguntar o decir algo.
            	
            */
            //NodePila e = lista.getFirst();
            while(!lista.Es_vacia()){
                NodePila e = lista.getFirst();
           
                if (String.valueOf(e.getData()) == "0" || String.valueOf(e.getData()) == "1" || String.valueOf(e.getData()) == "2" || String.valueOf(e.getData()) == "3" || String.valueOf(e.getData()) == "4" || String.valueOf(e.getData()) == "5" || String.valueOf(e.getData()) == "6" || String.valueOf(e.getData()) == "7" || String.valueOf(e.getData()) == "8" || String.valueOf(e.getData()) == "9"){
                    pila.Push(String.valueOf(e.getData()));
                }
                if(e.getData() == "x"){
                    pila.Push(String.valueOf(e.getData()));
                }
                if(e.getData() == persona){
                    pila.Push(String.valueOf(e.getData()));
                }
                if(String.valueOf(e.getData())== "+" || String.valueOf(e.getData())== "-" || String.valueOf(e.getData())== "*" || String.valueOf(e.getData())== "/"){
                    if (pila.getSize() < 2){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else{
                        NodePila A1 = pila.getpTop();
                        pila.Pop();
                        NodePila A2 = pila.getpTop();
                        pila.Pop();
                        persona.setRoot((Node) e.getData());
                        persona.getRoot().setLeft((Node) A1.getData());
                        persona.getRoot().setRight((Node) A2.getData());
                        pila.Push(persona);
                    } 
                    
                }
                e= e.getpNext();
            }
            if(pila.isEmpty() || pila.getSize() > 1){
                JOptionPane.showMessageDialog(null, "Error");
            }else{
                NodePila e = pila.getpTop();
                if(e.getData()!= persona){
                    RBTree personaE = new RBTree();
                    personaE.setRoot((Node) e.getData());
                }  
            }
            while(pila.isEmpty() == false){
                pila.Pop();
            }    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Operaciones Matem??ticas");

        jLabel2.setText("Ruta Absoluta del Archivo");

        jButton1.setText("Cargar Archivo .txt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Arbol");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Visualizar Arbol");

        jLabel3.setText("Integrantes:");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tom??s Gonz??lez", "Jes??s R??os", "Andr??s Romero" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(16, 16, 16)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ListaSimple listas= new ListaSimple();
        listas=lista.cambiar();
        //lista.cambiar();
        listas.Imprimir_lista();
        //System.out.println(listas);
        if (aux) {
            if(lista.getFirst().getData().equals("+") || lista.getFirst().getData().equals("*") || lista.getFirst().getData().equals("-") || lista.getFirst().getData().equals("/") || lista.getFirst().getData().equals("=")){
                JOptionPane.showMessageDialog(null, "Es prefija.");
            } else if(lista.getFirst().getpNext().getData().equals("+") || lista.getFirst().getpNext().getData().equals("*") || lista.getFirst().getpNext().getData().equals("-") || lista.getFirst().getpNext().getData().equals("/")){
                JOptionPane.showMessageDialog(null, "Es infija.");
            } else {
                JOptionPane.showMessageDialog(null, lista.getFirst().getData());
                JOptionPane.showMessageDialog(null, lista.getFirst().getpNext().getData());
                JOptionPane.showMessageDialog(null, "Es postfija.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Todavia no ha cargado ningun archivo");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getName();
            String filepath = f.getAbsolutePath();
            String name = filename.substring(filename.length() - 3);
            if (filename.length() > 3) {
                if (name.equals("txt")) {
                    jLabel2.setText(filepath);
                    JOptionPane.showMessageDialog(null, "Formato del Archivo: " + name);
                    lista=leer_txt(filepath);
                    lista.Imprimir_lista();
                    aux = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo debe ser de tipo txt. No " + name);
                }
            } else {
                // whatever is appropriate in this case
                JOptionPane.showMessageDialog(null, "El archivo tiene menos de tres caracteres. ");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error a subir el archivo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
