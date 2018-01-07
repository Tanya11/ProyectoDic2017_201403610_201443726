package Archivo;

import Conexion.Conexion;
import java.io.*;
import org.jdom2.*;
import javax.swing.*;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Usuario
 */
public class Lector {

    private String path;
    private final Conexion conexion;

    public Lector(Conexion conexion) {
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
        if (path.length() == 0)
            return;
        String ano, genero, nombreArtista, nombreAlbum;
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(path);
            InputStream inputStream = new FileInputStream(xmlFile);
            InputStreamReader reader = new InputStreamReader(inputStream, "ISO-8859-1");
            Document document = (Document) builder.build(reader);
            Element rootNode = document.getRootElement();
            List<Element> listUsuarios = ((Element) rootNode.getChildren().get(0)).getChildren();
            List<Element> listArtistas = ((Element) rootNode.getChildren().get(1)).getChildren();
            for (Element Usuario : listUsuarios) {
                conexion.insertar_usuario(Usuario.getChildTextTrim("nombre").replace("&amp;", "&"), Usuario.getChildTextTrim("pass").replace("&amp;", "&"));
                System.out.println("---------------------------------------");
            }
            for (Element artista : listArtistas) {
                nombreArtista = artista.getChildTextTrim("nombre");
                List<Element> albumes = ((Element) artista.getChildren().get(1)).getChildren();
                for (Element album : albumes) {
                    nombreAlbum = album.getChildTextTrim("nombre");
                    genero = album.getChildTextTrim("genero");
                    ano = album.getChildTextTrim("año");
                    List<Element> canciones = ((Element) album.getChildren().get(3)).getChildren();
                    for (Element cancion : canciones)
                        conexion.agregar_cancion(ano.replace("&amp;", "&"), genero.replace("&amp;", "&"), nombreArtista.replace("&amp;", "&"), nombreAlbum.replace("&amp;", "&"), cancion.getChildTextTrim("nombre").replace("&amp;", "&"), cancion.getChildTextTrim("path").replace("&amp;", "&"));
                }
            }
            JOptionPane.showMessageDialog(null, "Archivo leído.");
        } catch (IOException | JDOMException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
