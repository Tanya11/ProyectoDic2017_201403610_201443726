/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyectodiciembre;

import java.io.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Usuario
 */
public class LeerArchivo {

    private String path;
    private Conexion conexion;

    public LeerArchivo(Conexion conexion) {
        path = "";
        this.conexion = conexion;
    }

    public void Archivo() {
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.setFileFilter(new FileNameExtensionFilter("Archivos xml", "xml"));
        int a = seleccionar.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            File archivo = seleccionar.getSelectedFile();
            path = archivo.getAbsolutePath();
            Leer(path);
        }
    }

    public void Leer(String path) {
        String anoAlbum, genero, nombreArtista, nombreAlbum, cadena, nombreCancion;
        String nombreUser, contrasenaUser;
        if (path.length() == 0) {
            return;
        }
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(path);
        try {
            InputStream inputStream = new FileInputStream(xmlFile);
            InputStreamReader reader = new InputStreamReader(inputStream, "ISO-8859-1");
            Document document = (Document) builder.build(reader);
            Element rootNode = document.getRootElement();
            List<Element> listUsuarios = ((Element) rootNode.getChildren().get(0)).getChildren();
            List<Element> listArtistas = ((Element) rootNode.getChildren().get(1)).getChildren();

            for (Element Usuario : listUsuarios) {
                System.out.println("\tNombre\t\tContraseña");
                nombreUser = Usuario.getChildTextTrim("nombre");
                contrasenaUser = Usuario.getChildTextTrim("pass");
                System.out.println("\t" + nombreUser + "\t\t" + contrasenaUser); //nombre del artista 
                //llamar a conexion para llenar lista de usuarios
                conexion.insertar_usuario(nombreUser, contrasenaUser);
                System.out.println("---------------------------------------");
            }
            for (Element artista : listArtistas) {
                // System.out.println("\t" + artista.getChildTextTrim("nombre")); ////nombre del artista 
                nombreArtista = artista.getChildTextTrim("nombre");
                List<Element> albumes = ((Element) artista.getChildren().get(1)).getChildren();
                for (Element album : albumes) {
                    //  System.out.println("\t\t" + album.getChildTextTrim("nombre") + "\t" + album.getChildTextTrim("genero") + "\t" + album.getChildTextTrim("año")); //nombre del artista 
                    nombreAlbum = album.getChildTextTrim("nombre");
                    genero = album.getChildTextTrim("genero");
                    anoAlbum = album.getChildTextTrim("año");
                    List<Element> canciones = ((Element) album.getChildren().get(3)).getChildren();
                    for (Element cancion : canciones) {
                        // System.out.println("\t\t\t" + cancion.getChildTextTrim("nombre") + "\t" + cancion.getChildTextTrim("path")); //nombre del artista 
                        nombreCancion = cancion.getChildTextTrim("nombre");
                        cadena = cancion.getChildTextTrim("path");
                        conexion.agregar_cancion(anoAlbum, genero, nombreArtista, nombreAlbum, nombreCancion, cadena);
                        System.out.println(nombreCancion);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Archivo leído.");

        } catch (IOException | JDOMException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
