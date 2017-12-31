/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.proyectodiciembre;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;





/**
 *
 * @author Usuario
 */
public class LeerArchivo {

    private String path;

    public LeerArchivo() {
        path = "";
    }
    
    public void Archivo(){
      JFileChooser seleccionar = new JFileChooser();
        seleccionar.setFileFilter(new FileNameExtensionFilter("Archivos xml","xml"));
        int a = seleccionar.showOpenDialog(null);
        if(a == JFileChooser.APPROVE_OPTION){
            File archivo = seleccionar.getSelectedFile();
            path = archivo.getAbsolutePath();
            Leer(path);
            try {
               
                } catch (Exception e) {
            }
        }
    }
   
    public void Leer(String path){
        if(path.length() == 0)
            return;
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(path);
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List<Element> listUsuarios = ((Element)rootNode.getChildren().get(0)).getChildren();
            List<Element> listArtistas = ((Element)rootNode.getChildren().get(1)).getChildren();
            
            for (Element Usuario : listUsuarios) {
                System.out.println("\tNombre\t\tContraseña");
                System.out.println("\t" + Usuario.getChildTextTrim("nombre") + "\t\t" + Usuario.getChildTextTrim("pass")); //nombre del artista 
                System.out.println("---------------------------------------");
            }
            for (Element artista : listArtistas) {
                System.out.println("\t" + artista.getChildTextTrim("nombre")); //nombre del artista 
                List<Element> albumes = ((Element) artista.getChildren().get(1)).getChildren();
                for (Element album : albumes) {
                    System.out.println("\t\t" + album.getChildTextTrim("nombre") + "\t" + album.getChildTextTrim("genero") + "\t" + album.getChildTextTrim("año")); //nombre del artista 
                    List<Element> canciones = ((Element) album.getChildren().get(3)).getChildren();
                    for (Element cancion : canciones) {
                        System.out.println("\t\t\t" + cancion.getChildTextTrim("nombre") + "\t" + cancion.getChildTextTrim("path") ); //nombre del artista 
                    }
                }
                System.out.println("---------------------------------------");
            }

        } catch (IOException | JDOMException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
