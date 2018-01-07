package Interfaz;

import Conexion.Conexion;
import Archivo.Lector;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Login extends javax.swing.JFrame {

    private final Conexion conexion;

    public Login() {
        initComponents();
        conexion = new Conexion();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.setName("nombre"); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 229, 29));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/iniciarSesion.jpg"))); // NOI18N
        jButton1.setName("IniciarSesion"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 229, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/spotify.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 230, 70));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("LEER ARCHIVO");
        jButton2.setName("LeerArchivo"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 120, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/google.jpg"))); // NOI18N
        jButton3.setName("Google"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 80, 30));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 230, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre o  correo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/login.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Lector leerarchivo = new Lector(conexion);
        leerarchivo.Archivo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!(jTextField1.getText().length() > 0) || !(jPasswordField1.getPassword().length > 0))
            System.out.println("Ingrese su nombre de usuario y contraseña.");
        else {
            String contrasena = "";
            for (int i = 0; i < jPasswordField1.getPassword().length; i++)
                contrasena += jPasswordField1.getPassword()[i];
            String resultado = conexion.ingresar(jTextField1.getText(), contrasena);
            if (resultado == null)
                JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error.");
            else if ("Ingreso exitoso.".equals(resultado)){
                (new Principal(conexion, jTextField1.getText(), contrasena)).setVisible(true);
            }else
                JOptionPane.showMessageDialog(rootPane, "Credenciales incorrectas.");
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
