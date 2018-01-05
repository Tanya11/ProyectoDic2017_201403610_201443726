package edd.proyectodiciembre;

import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    private int canciones;
    private String[] seleccionado;
    private final Conexion conexion;
    private final Reproductor Reproductor;

    public Principal(Conexion conexion) {
        initComponents();
        ocultar();
        this.conexion = conexion;
        llenar();
        Reproductor = new Reproductor();
    }
    
    private void ocultar(){
        anterior.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jTextField2.setForeground(new Color(153, 153, 153));
        jTextField3.setForeground(new Color(153, 153, 153));
        jTextField4.setForeground(new Color(153, 153, 153));
        jTextField5.setForeground(new Color(153, 153, 153));
        jTextField2.setText("Año");
        jTextField3.setText("Genero");
        jTextField4.setText("Artista");
        jTextField5.setText("Album");
    }
    
    private void llenar() {
        canciones = 0;
        String Linea[] = new String[conexion.actual.size()];
        for (Cancion actual : conexion.actual)
            Linea[canciones++] = canciones + " -> " + actual.getArtista() + " ---- " + actual.getAlbum() + " ---- " + actual.getAno() + " ---- " + actual.getGenero() + " ---- " + actual.getNombre() + " ---- " + actual.getPath();
        jList1.setModel(new AbstractListModel() {
            String[] Lineas = Linea;
            @Override
            public int getSize() { return Lineas.length; }
            @Override
            public Object getElementAt(int index) { return Lineas[index]; }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        pausa = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        play = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 50, 60));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CERRAR SESION");
        jButton2.setActionCommand("");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("LOGOUT"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 130, 30));

        jTextField1.setBackground(new java.awt.Color(0, 0, 51));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 204, 0));
        jTextField1.setName("tex2"); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, 30));

        jButton3.setBackground(new java.awt.Color(0, 0, 51));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setName("CargarArchivo"); // NOI18N
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 80, 30));

        jComboBox1.setBackground(new java.awt.Color(0, 0, 51));
        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige uno...", "Todas las canciones de un artista", "Todas las canciones de un album", "Todas las canciones de un genero", "Todas las canciones de un año", "Todas las canciones de tu cola", "Shuffle play" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 150, 30));

        pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.jpg"))); // NOI18N
        pausa.setEnabled(false);
        pausa.setName("pausa"); // NOI18N
        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });
        getContentPane().add(pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 70, 60));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atras.jpg"))); // NOI18N
        anterior.setEnabled(false);
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 50, 60));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p.jpg"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 60, 60));

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siguiente.jpg"))); // NOI18N
        siguiente.setEnabled(false);
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 60, 60));

        jButton12.setBackground(new java.awt.Color(51, 102, 255));
        jButton12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("CONFIGURACION");
        jButton12.setActionCommand("");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.setName("ColaCanciones"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 120, 30));

        jButton14.setBackground(new java.awt.Color(51, 255, 0));
        jButton14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Agregar a la lista");
        jButton14.setActionCommand("");
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton14.setName("MIX"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 130, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 130, 30));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gris.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 740, 130));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modo de reproducción");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jList1.setBackground(new java.awt.Color(0, 0, 51));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 690, 410));

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 150, -1));

        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setText("Album");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 150, -1));

        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setText("Genero");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 150, 20));

        jTextField5.setForeground(new java.awt.Color(153, 153, 153));
        jTextField5.setText("Artista");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/azul-marino.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 630));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/azul.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Configuracion con = new Configuracion(conexion);
        con.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (seleccionado.length > 0)
            conexion.agregar_a_lista(seleccionado[4], seleccionado[5]);
        else
            System.out.println("error");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        conexion.salir();
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        seleccionado = (jList1.getSelectedValue().toString().split(" -> ")[1]).split(" ---- ");
    }//GEN-LAST:event_jList1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ocultar();
        String seleccion = ((javax.swing.JComboBox) evt.getSource()).getSelectedItem().toString();
        switch (seleccion) {
            case "Todas las canciones de un artista":
                anterior.setVisible(true);
                jTextField2.setVisible(true);
                jTextField2.setText("Artista");
                break;
            case "Todas las canciones de un album":
                anterior.setVisible(true);
                jTextField2.setVisible(true);
                jTextField3.setVisible(true);
                jTextField4.setVisible(true);
                jTextField5.setVisible(true);
                break;
            case "Todas las canciones de un genero":
                anterior.setVisible(true);
                jTextField2.setVisible(true);
                jTextField2.setText("Genero");
                break;
            case "Todas las canciones de un año":
                jTextField2.setVisible(true);
                jTextField2.setText("Año");
                anterior.setVisible(true);
                break;
            case "Todas las canciones de tu cola":
                anterior.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        pausa.setEnabled(true);
        anterior.setEnabled(true);
        siguiente.setEnabled(true);
        play.setEnabled(false);
        String modo, p1, p2, p3, p4, lista;
        modo = jComboBox1.getSelectedItem().toString();
        if (modo.equals("Elige uno...")) {
            JOptionPane.showMessageDialog(rootPane, "Elige un modo de reproducción.");
        } else if(Reproductor.modo.equals(modo)){
            Reproductor.reproducir();
        } else {
            lista = "";
            switch (modo) {
                case "Todas las canciones de un artista":
                    p1 = jTextField2.getText();
                    if(p1.equals("Artista") || p1.length() == 0){
                        JOptionPane.showMessageDialog(rootPane, "Escriba el nombre del artista.");
                    }else{
                        lista = conexion.canciones_artista(p1);
                    }
                    break;
                case "Todas las canciones de un album":
                    p1 = jTextField2.getText();
                    p2 = jTextField3.getText();
                    p3 = jTextField4.getText();
                    p4 = jTextField5.getText();
                    if((p1.equals("Año") || p1.length() == 0) && (p2.equals("Genero") || p2.length() == 0) && (p3.equals("Artista") || p3.length() == 0) && (p4.equals("Album") || p4.length() == 0)){
                        JOptionPane.showMessageDialog(rootPane, "Escriba todos los parámetros.");
                    }else{
                        lista = conexion.canciones_album(p1, p2, p3, p4);
                    }
                    break;
                case "Todas las canciones de un genero":
                    p1 = jTextField2.getText();
                    if(p1.equals("Genero") || p1.length() == 0){
                        JOptionPane.showMessageDialog(rootPane, "Escriba el género.");
                    }else{
                        lista = conexion.canciones_genero(p1);
                    }
                    break;
                case "Todas las canciones de un año":
                    p1 = jTextField2.getText();
                    if(p1.equals("Año") || p1.length() == 0){
                        JOptionPane.showMessageDialog(rootPane, "Escriba el año.");
                    }else{
                        lista = conexion.canciones_ano(p1);
                    }
                    break;
                case "Todas las canciones de tu cola":
                    lista = conexion.canciones_usuario();
                    break;
                case "Shuffle play":
                    int aleatorio = 0;
                    String[] atributos;
                    for(int i = 0; i < canciones; i++){
                        aleatorio = (int) (Math.random() * canciones);
                        atributos = (jList1.getModel().getElementAt(aleatorio).toString().split(" -> ")[1]).split(" ---- ");
                        lista += atributos[4] + " ---- " + atributos[5] + "\n";
                    }
                    break;
            }
            if(lista == null){
                System.out.println("Error: No se ha podido obtener la lista.");
            } else if(lista.length() > 0){
                Reproductor.modo = modo;
                ArrayList<Cancion> actual = new ArrayList<>();
                String[] lineas = lista.split("\n");
                String[] atributos;
                for(String linea: lineas){
                    atributos = linea.split(" ---- ");
                    actual.add(new Cancion(atributos[0], atributos[1], "", "", "", ""));
                }
                //Reproductor.reproducir(actual); //Descomentar cuando ya hayan canciones en la carpeta
                System.out.println("Listo");
            }
        }
    }//GEN-LAST:event_playActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.black);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.black);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.black);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.black);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausaActionPerformed
        play.setEnabled(true);
        pausa.setEnabled(false);
    }//GEN-LAST:event_pausaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton pausa;
    private javax.swing.JButton play;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
