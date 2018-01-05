/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyectodiciembre;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Configuracion extends javax.swing.JFrame {

    private Conexion conexion;

    public Configuracion(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        ocultar();
    }

    private void ocultar() {
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jButton1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 157, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 157, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 157, -1));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 157, -1));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 157, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confi.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 430));

        jMenu1.setText("Eliminar");

        jMenuItem1.setText("Eliminar año");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar Genero");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Eliminar Artistas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Eliminar Artista");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Eliminar Album");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Eliminar Cancion");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Eliminar Usuario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Graficar");

        jMenuItem8.setText("Matriz");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Arbol B");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Arbol BB");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Lista Circular");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Lista Doble de Usuarios");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Cola Circular Usuarios");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel1.setText("Nombre:");
        jLabel2.setText("Contraseña:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar usuario.");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jLabel1.setVisible(true);
        jLabel1.setText("Año:");
        jTextField1.setText("");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar año.");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jLabel1.setVisible(true);
        jTextField1.setText("");
        jLabel1.setText("Genero:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar genero.");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar artistas.");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jTextField1.setText("");
        jLabel1.setVisible(true);
        jLabel1.setText("Artista:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar artista.");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jLabel3.setText("Artista:");
        jLabel4.setText("Album:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar album.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ocultar();
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        jTextField5.setVisible(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jLabel3.setText("Artista:");
        jLabel4.setText("Album:");
        jLabel5.setText("Canción:");
        jButton1.setVisible(true);
        jButton1.setText("Eliminar canción.");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String seleccion = ((javax.swing.JButton) evt.getSource()).getText();
        switch (seleccion) {
            case "Eliminar usuario.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0) {
                    conexion.eliminar_usuario(jTextField1.getText(), jTextField2.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese ambos campos o ke ze io");
                }
                break;
            case "Eliminar año.":
                if (jTextField1.getText().length() > 0) {
                    conexion.eliminar_ano(jTextField1.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese el año o ke ze io");
                }
                break;
            case "Eliminar genero.":
                if (jTextField1.getText().length() > 0) {
                    conexion.eliminar_genero(jTextField1.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese el genero o ke ze io");
                }
                break;
            case "Eliminar artistas.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0) {
                    conexion.eliminar_artistas(jTextField1.getText(), jTextField2.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos o ke ze io");
                }
                break;
            case "Eliminar artista.":
                if (jTextField1.getText().length() > 0) {
                    conexion.eliminar_artista(jTextField1.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese el artista o ke ze io");
                }
                break;
            case "Eliminar album.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0 && jTextField3.getText().length() > 0 && jTextField4.getText().length() > 0) {
                    conexion.eliminar_album(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos o ke ze io");
                }
                break;
            case "Eliminar canción.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0 && jTextField3.getText().length() > 0 && jTextField4.getText().length() > 0 && jTextField5.getText().length() > 0) {
                    conexion.eliminar_cancion(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos o ke ze io");
                }
                break;
            case "Graficar Arbol B.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0) {
                    conexion.graficar_arbol_b(jTextField1.getText(), jTextField2.getText());
                    try {
                        Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\ArbolB.png"));
                    } catch (IOException ex) {
                        System.out.println("Error " + ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos o ke ze io");
                }
                break;
            case "Graficar Arbol Binario.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0 && jTextField3.getText().length() > 0) {
                    conexion.graficar_abb(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
                    try {
                        Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\ArbolBinario.png"));
                    } catch (IOException ex) {
                        System.out.println("Error " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos");
                }
                break;
            case "Graficar Lista Circular.":
                if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0 && jTextField3.getText().length() > 0 && jTextField4.getText().length() > 0) {
                    conexion.graficar_lista_circular(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText());
                    try {
                        Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\ListaCircular.png"));
                    } catch (IOException ex) {
                        System.out.println("Error " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos ");
                }
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "Error extraño...");
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ocultar();
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jButton1.setVisible(true);
        jButton1.setText("Graficar Arbol B.");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        //abb
        ocultar();
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jLabel3.setText("Artista:");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jButton1.setVisible(true);
        jButton1.setText("Graficar Arbol Binario.");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ocultar();
        jLabel1.setText("Año:");
        jLabel2.setText("Genero:");
        jLabel3.setText("Artista:");
        jLabel4.setText("Album:");
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        jButton1.setVisible(true);
        jButton1.setText("Graficar Lista Circular.");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        ocultar();
        conexion.graficar_lista_doble();
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\ListaDoble.png"));
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        ocultar();
        conexion.graficar_lista_circular_usuario();
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\ListaCircular.png"));
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ocultar();
        conexion.graficar_matriz();
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\Matriz.png"));
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
