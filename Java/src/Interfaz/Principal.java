package Interfaz;

import Interfaz.Configuracion;
import Reproductor.Cancion;
import Conexion.Conexion;
import Reproductor.Reproductor;
import javax.swing.*;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    private int canciones;
    private String[] seleccionado;
    private boolean play_is_enable;
    private final Conexion conexion;
    private final Reproductor Reproductor;
    private final String usuario, contrasena;
    private Thread actualizar_interfaz, actualizar_label;

    public Principal(Conexion conexion, String usuario, String contrasena) {
        super("Bienvenido " + usuario);
        initComponents();
        ocultar();
        this.conexion = conexion;
        this.usuario = usuario;
        this.contrasena = contrasena;
        Reproductor = new Reproductor();
        actualizar_interfaz();
        play_is_enable = true;
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
    
    private void actualizar_interfaz() {
        actualizar_interfaz = new Thread(){
            @Override
            public void run(){
                try {
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
                    jList1.setForeground(new Color(0,204,0));
                    jList1.repaint();
                    if (Reproductor.actual != null)
                        jLabel5.setText(Reproductor.actual.getNombre());
                    sleep(1000);
                    actualizar_interfaz();
                } catch (InterruptedException e) {}
            }
        };
        actualizar_interfaz.start();
    }
    
    private void actualizar_label(){
        actualizar_label = new Thread(){
            @Override
            public void run(){
                try {
                    if (Reproductor.actual != null)
                        jLabel5.setText(Reproductor.actual.getNombre());
                    sleep(1000);
                    actualizar_label();
                } catch (InterruptedException e) {}
            }
        };
        actualizar_label.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/otro.jpg"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 90));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 0));
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
        jTextField1.setText("Buscar");
        jTextField1.setName("tex2"); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, 30));

        jComboBox1.setBackground(new java.awt.Color(0, 0, 51));
        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige uno...", "Todas las canciones de un artista", "Todas las canciones de un album", "Todas las canciones de un genero", "Todas las canciones de un año", "Todas las canciones de tu cola", "Shuffle play" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, 30));

        pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/play.jpg"))); // NOI18N
        pausa.setName("pausa"); // NOI18N
        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });
        getContentPane().add(pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 80, 70));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/atras.jpg"))); // NOI18N
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 60, 70));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/p.jpg"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 70, 70));

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/siguiente.jpg"))); // NOI18N
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 70, 70));

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

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 180, 30));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/gris.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 740, 130));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setText("Modo de reproducción");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jList1.setBackground(new java.awt.Color(51, 153, 255));
        jList1.setForeground(new java.awt.Color(0, 0, 102));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 690, 410));

        jTextField2.setBackground(new java.awt.Color(0, 0, 51));
        jTextField2.setForeground(new java.awt.Color(0, 153, 0));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 150, -1));

        jTextField3.setBackground(new java.awt.Color(0, 0, 51));
        jTextField3.setForeground(new java.awt.Color(0, 153, 0));
        jTextField3.setText("Album");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 150, -1));

        jTextField4.setBackground(new java.awt.Color(0, 0, 51));
        jTextField4.setForeground(new java.awt.Color(0, 153, 0));
        jTextField4.setText("Genero");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 150, -1));

        jTextField5.setBackground(new java.awt.Color(0, 0, 51));
        jTextField5.setForeground(new java.awt.Color(0, 153, 0));
        jTextField5.setText("Artista");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/azul-marino.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 630));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/azul.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Configuracion con = new Configuracion(conexion, usuario, contrasena);
        con.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Reproductor.modo = "";
        if (seleccionado != null && seleccionado.length > 0)
            conexion.agregar_a_lista(seleccionado[4], seleccionado[5], usuario, contrasena);
        else
            System.out.println("error");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        conexion.salir();
        Reproductor.detener();
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        seleccionado = (jList1.getSelectedValue().toString().split(" -> ")[1]).split(" ---- ");
    }//GEN-LAST:event_jList1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ocultar();
        Reproductor.detener();
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
        if(play_is_enable){
            String modo, parametro1, parametro2, parametro3, parametro4, cadena;
            modo = jComboBox1.getSelectedItem().toString();
            if (modo.equals("Elige uno...")) {
                JOptionPane.showMessageDialog(rootPane, "Elige un modo de reproducción.");
                pausa.setEnabled(false);
                anterior.setEnabled(false);
                siguiente.setEnabled(false);
                play.setEnabled(true);
            } else if(Reproductor.modo.equals(modo)){
                Reproductor.reproducir();
            } else {
                try {
                    Reproductor.detener();
                } catch (Exception e) {}
                cadena = "";
                switch (modo) {
                    case "Todas las canciones de un artista":
                        parametro1 = jTextField2.getText();
                        if(parametro1.equals("Artista") || parametro1.length() == 0){
                            JOptionPane.showMessageDialog(rootPane, "Escriba el nombre del artista.");
                        }else{
                            cadena = conexion.canciones_artista(parametro1);
                            if (cadena == null || cadena.length() == 0)
                                JOptionPane.showMessageDialog(rootPane, "El artista no existe.");
                        }
                        break;
                    case "Todas las canciones de un album":
                        parametro1 = jTextField2.getText();
                        parametro2 = jTextField3.getText();
                        parametro3 = jTextField4.getText();
                        parametro4 = jTextField5.getText();
                        if((parametro1.equals("Año") || parametro1.length() == 0) && (parametro2.equals("Genero") || parametro2.length() == 0) && (parametro3.equals("Artista") || parametro3.length() == 0) && (parametro4.equals("Album") || parametro4.length() == 0)){
                            JOptionPane.showMessageDialog(rootPane, "Escriba todos los parámetros.");
                        }else{
                            cadena = conexion.canciones_album(parametro1, parametro2, parametro3, parametro4);
                            if (cadena == null || cadena.length() == 0)
                                JOptionPane.showMessageDialog(rootPane, "El album no existe.");
                        }
                        break;
                    case "Todas las canciones de un genero":
                        parametro1 = jTextField2.getText();
                        if(parametro1.equals("Genero") || parametro1.length() == 0){
                            JOptionPane.showMessageDialog(rootPane, "Escriba el género.");
                        }else{
                            cadena = conexion.canciones_genero(parametro1);
                            if (cadena == null || cadena.length() == 0)
                                JOptionPane.showMessageDialog(rootPane, "El género no existe.");
                        }
                        break;
                    case "Todas las canciones de un año":
                        parametro1 = jTextField2.getText();
                        if(parametro1.equals("Año") || parametro1.length() == 0){
                            JOptionPane.showMessageDialog(rootPane, "Escriba el año.");
                        }else{
                            cadena = conexion.canciones_ano(parametro1);
                            if (cadena == null || cadena.length() == 0)
                                JOptionPane.showMessageDialog(rootPane, "El año no existe.");
                        }
                        break;
                    case "Todas las canciones de tu cola":
                        cadena = conexion.canciones_usuario(usuario, contrasena);
                        if (cadena == null || cadena.length() == 0)
                            JOptionPane.showMessageDialog(rootPane, "Tu cola está vacía.");
                        break;
                    case "Shuffle play":
                        cadena = conexion.canciones_shuffle();
                        int aleatorio, size;
                        String[] atributos;
                        ArrayList<Integer> agregados = new ArrayList<>();
                        if (agregados.isEmpty())
                            cadena = "";
                        for(size = agregados.size(); size < canciones; size = agregados.size()){
                            aleatorio = (int) (Math.random() * canciones);
                            if(!agregados.contains(aleatorio)){
                                atributos = (jList1.getModel().getElementAt(aleatorio).toString().split(" -> ")[1]).split(" ---- ");
                                cadena += atributos[4] + " ---- " + atributos[5] + "\n";
                                agregados.add(aleatorio);
                            }
                        }
                        if (cadena.equals("") || cadena.length() == 0)
                            JOptionPane.showMessageDialog(rootPane, "No se han agregado canciones.");
                        break;
                }
                if(cadena == null){
                    System.out.println("Error: No se ha podido obtener la lista.");
                } else if(cadena.length() > 0){
                    Reproductor.modo = modo;
                    ArrayList<Cancion> actual = new ArrayList<>();
                    String[] lineas = cadena.split("\n");
                    String[] atributos;
                    for(String linea: lineas){
                        atributos = linea.split(" ---- ");
                        actual.add(new Cancion(atributos[0], atributos[1], "", "", "", ""));
                    }
                    Reproductor.reproducir(actual);
                }
            }
        }
        play_is_enable = false;
    }//GEN-LAST:event_playActionPerformed
    
    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.white);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.white);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.white);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.white);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausaActionPerformed
        if(!play_is_enable)
            Reproductor.pausar();
        play_is_enable = true;
    }//GEN-LAST:event_pausaActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        if(!play_is_enable)
            Reproductor.anterior();
        play_is_enable = true;
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if(!play_is_enable)
            Reproductor.siguiente();
        play_is_enable = true;
    }//GEN-LAST:event_siguienteActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            String cadena = jTextField1.getText();
            try { actualizar_interfaz.stop(); } catch (Exception e) { }
            if(cadena.length() > 0){
                try {
                    cadena = conexion.buscar_album(cadena);
                    canciones = 0;
                    String[] cancion = cadena.split("\n");
                    String Linea[] = new String[cancion.length];
                    for (String linea : cancion)
                        Linea[canciones++] = canciones + " -> " + linea;
                    jList1.setModel(new AbstractListModel() {
                        String[] Lineas = Linea;
                        @Override
                        public int getSize() { return Lineas.length; }
                        @Override
                        public Object getElementAt(int index) { return Lineas[index]; }
                    });
                    jList1.setForeground(new Color(0,204,0));
                    jList1.repaint();
                    actualizar_label();
                } catch (Exception e) { }
            }else
                actualizar_interfaz();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        ((javax.swing.JTextField) evt.getSource()).setText("");
        ((javax.swing.JTextField) evt.getSource()).setForeground(Color.white);
    }//GEN-LAST:event_jTextField1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
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
